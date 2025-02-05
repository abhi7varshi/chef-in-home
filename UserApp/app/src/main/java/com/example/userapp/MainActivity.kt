@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.userapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.userapp.features.auth.ui.LoginScreen
import com.example.userapp.features.auth.ui.LoginViewModel
import com.example.userapp.ui.theme.UserAppTheme
import com.example.userapp.viewmodels.SplashScreenVm
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var oneTapClient: SignInClient
    private var verificationId by mutableStateOf<String?>(null)
    private var otpCode by mutableStateOf("")

    private val widgetId = "YourWidgetId" // Your Widget ID from MSG91 dashboard
    private val authToken = "YourAuthToken" // Your Auth Token from MSG91 dashboard

    private var phoneNumber by mutableStateOf("")
    private var otp by mutableStateOf("")
    private var otpSent by mutableStateOf(false)
    private var verificationStatus by mutableStateOf("")

    private val viewModel: SplashScreenVm by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
//        FirebaseAuth.getInstance().firebaseAuthSettings.setAppVerificationDisabledForTesting(true)
//        FirebaseAuth.getInstance().firebaseAuthSettings.forceRecaptchaFlowForTesting(true)
        oneTapClient = Identity.getSignInClient(this)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.isLoading.value
        }

        setContent {
            UserAppTheme {
//                Navigation()
//                LoginScreen()
//                HomeScreen()
//                GoogleSignInScreen(
//                    onSignInClick = { launchGoogleSignIn() },
//                    onSignOutClick = { signOut() },
//                    user = auth.currentUser
//                )
                GoogleAndPhoneAuthScreen(
                    onGoogleSignInClick = { launchGoogleSignIn() },
                    onSignOutClick = { signOut() },
                    user = auth.currentUser,
                )
            }
        }
    }

    // Function to start Google Sign-In
    private fun launchGoogleSignIn() {
        val signInRequest = GetSignInIntentRequest.builder()
            .setServerClientId("134807327020-eeuulu48deneogugqh8a7tg1e9l5oo77.apps.googleusercontent.com") // Replace with your actual Firebase Web Client ID
            .build()

        oneTapClient.getSignInIntent(signInRequest)
            .addOnSuccessListener { pendingIntent ->
                googleSignInLauncher.launch(
                    IntentSenderRequest.Builder(pendingIntent.intentSender).build()
                )
            }
            .addOnFailureListener {
                println("Google Sign-In Failed: ${it.message}")
            }
    }

    // Register Activity Result API
    private val googleSignInLauncher =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                try {
                    val credential = oneTapClient.getSignInCredentialFromIntent(result.data)
                    val googleIdToken = credential.googleIdToken

                    if (googleIdToken != null) {
                        val firebaseCredential =
                            GoogleAuthProvider.getCredential(googleIdToken, null)

                        auth.signInWithCredential(firebaseCredential)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val user = auth.currentUser
                                    println("Firebase Auth Success: ${user?.displayName}")
                                } else {
                                    println("Firebase Auth Failed: ${task.exception?.message}")
                                }
                            }
                    }
                } catch (e: Exception) {
                    println("Google Sign-In Failed: ${e.message}")
                }
            }
        }

    // Phone Number Authentication with reCAPTCHA
    private fun startPhoneNumberVerification(phoneNumber: String) {
        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                auth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            println("Phone Auth Success: ${auth.currentUser?.phoneNumber}")
                        } else {
                            println("Phone Auth Failed: ${task.exception?.message}")
                        }
                    }
            }

            override fun onVerificationFailed(e: FirebaseException) {
                println("Phone Auth Error: ${e.message}")
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                this@MainActivity.verificationId = verificationId
                println("OTP Sent to $phoneNumber")
            }
        }

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun verifyOtpCode(otp: String) {
        val credential = verificationId?.let {
            PhoneAuthProvider.getCredential(it, otp)
        }
        credential?.let {
            auth.signInWithCredential(it)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        println("Phone Auth Success: ${auth.currentUser?.phoneNumber}")
                    } else {
                        println("Phone Auth Failed: ${task.exception?.message}")
                    }
                }
        }
    }

    // Function to Sign Out
    private fun signOut() {
        auth.signOut()
        println("User signed out successfully")
    }

    companion object {
        private const val GOOGLE_SIGN_IN_REQUEST_CODE = 1001
    }

}


@Composable
fun GoogleAndPhoneAuthScreen(
    onGoogleSignInClick: () -> Unit,
    onSignOutClick: () -> Unit,
    user: FirebaseUser?,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var phoneNumber by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (uiState.isLoading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }

        if (user != null) {
            Text(text = "Welcome, ${user.phoneNumber ?: user.displayName}")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onSignOutClick) {
                Text("Sign Out")
            }
        } else {
            Button(onClick = onGoogleSignInClick) {
                Text("Sign in with Google")
            }
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Phone Number") }
            )

            Button(onClick = { viewModel.sendOTP(phoneNumber) }) {
                Text("Send OTP")
            }

            OutlinedTextField(
                value = otp,
                onValueChange = { otp = it },
                label = { Text("Enter OTP") }
            )

            Button(onClick = { viewModel.verifyOTP(otp) }) {
                Text("Verify OTP")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UserAppTheme {
        LoginScreen()
    }
}