@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.userapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.userapp.features.auth.ui.GoogleAndPhoneAuthScreen
import com.example.userapp.features.auth.ui.LoginViewModel
import com.example.userapp.features.restaurantScreen.RestaurantScreen
import com.example.userapp.ui.theme.UserAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModels()

    private val googleSignInLauncher =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                viewModel.handleSignInResult(result.data)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Ensure the splash screen is properly set up and call before super.onCreate()
        installSplashScreen()
        super.onCreate(savedInstanceState)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            UserAppTheme {
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                //LaunchedEffect is used for collecting flows that trigger one-time effects,
                // like launching an activity result.
                LaunchedEffect(Unit) {
                    viewModel.googleSignInIntent.collect { intentSender ->
                        intentSender?.let {
                            googleSignInLauncher.launch(IntentSenderRequest.Builder(it).build())
                        }
                    }
                }

                GoogleAndPhoneAuthScreen(
                    user = uiState.user,
                    onGoogleSignInClick = { viewModel.launchGoogleSignIn() },
                    onSignOutClick = { viewModel.signOut() }
                )
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}