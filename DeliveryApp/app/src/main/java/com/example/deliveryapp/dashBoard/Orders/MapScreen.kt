//package com.example.deliveryapp.dashBoard.Orders
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.viewinterop.AndroidView
//import com.example.deliveryapp.R
//import org.osmdroid.events.MapListener
//import org.osmdroid.events.ScrollEvent
//import org.osmdroid.events.ZoomEvent
//import org.osmdroid.util.GeoPoint
//import org.osmdroid.views.MapView
//import com.google.accompanist.permissions.rememberPermissionState
//import com.google.accompanist.permissions.ExperimentalPermissionsApi
//import com.google.accompanist.permissions.isGranted
//
//
//@Composable
//fun MapScreen(
//    onConfirmLocation: (String) -> Unit
//) {
//    // State for the center location
//    var centerLocation by remember { mutableStateOf<GeoPoint?>(null) }
//    // State for the address or display name
//    var addressText by remember { mutableStateOf("Fetching address...") }
//
//    // Here you might do a reverse geocoding whenever `centerLocation` changes
//    // For example, if you have a geocoder function, call it and update addressText
//
//    Scaffold (
//        topBar = {
//            // A simple search bar
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(Color.White)
//            ) {
//                TextField(
//                    value = "",
//                    onValueChange = { /* update search query if needed */ },
//                    placeholder = { Text("Search for area, apartment etc.") },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp)
//                )
//            }
//        },
//        bottomBar = {
//            // Bottom card with location info and confirm button
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(Color.White)
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = addressText,
//                    style = MaterialTheme.typography.bodyMedium,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Button (
//                    onClick = {
//                        // Confirm location
//                        onConfirmLocation(addressText)
//                    },
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Text("Confirm location")
//                }
//            }
//        }
//    ) { innerPadding ->
//        // The map with the center pin
//        MapWithCenterPin(
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxSize()
//        ) { center ->
//            centerLocation = center
//            // Potentially do reverse geocoding here, or call a function
//            // addressText = reverseGeocode(center.latitude, center.longitude)
//        }
//    }
//}
//
//
//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun RequestLocationPermission() {
////    val locationPermissionState = rememberPermissionState(
////        permission = Manifest.permission.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION
////    )
//
//    // On first load, request permission
////    LaunchedEffect (Unit) {
////        if (!locationPermissionState.status.isGranted) {
////            locationPermissionState.launchPermissionRequest()
////        }
////    }
//
//    // Show rationale or something if needed
//}
//
//@Composable
//fun OSMMapView(
//    modifier: Modifier = Modifier,
//    onMapReady: (MapView) -> Unit = {}
//) {
//    AndroidView(
//        modifier = modifier,
//        factory = { context ->
//            // Initialize MapView
//            val mapView = MapView(context).apply {
//                id = org.osmdroid.library.R.id.bubble_image
//                setMultiTouchControls(true)
//
//                // Set default tile source
//                // (OSMDroid by default uses OSM)
//                // Or you can specify: tileProvider.tileSource = TileSourceFactory.MAPNIK
//
//                // Zoom / center
//                controller.setZoom(15.0)
//                controller.setCenter(GeoPoint(12.9716, 77.5946)) // Bangalore center (example)
//            }
//            onMapReady(mapView)
//            mapView
//        },
//        update = { /* You can update the mapView if needed */ }
//    )
//}
//
//@Composable
//fun MapWithCenterPin(
//    modifier: Modifier = Modifier,
//    onCenterChanged: (GeoPoint) -> Unit
//) {
//    // State holder for the MapView
//    val mapViewRef = remember { mutableStateOf<MapView?>(null) }
//
//    Box(modifier = modifier) {
//        // 1) The MapView
//        OSMMapView(
//            modifier = Modifier.fillMaxSize(),
//            onMapReady = { mapView ->
//                mapViewRef.value = mapView
//
//                // Listen for map movements
//                mapView.addMapListener(object : MapListener {
//                    override fun onScroll(event: ScrollEvent?): Boolean {
//                        event?.let {
//                            val center = mapView.mapCenter as GeoPoint
//                            onCenterChanged(center)
//                        }
//                        return false
//                    }
//                    override fun onZoom(event: ZoomEvent?): Boolean {
//                        event?.let {
//                            val center = mapView.mapCenter as GeoPoint
//                            onCenterChanged(center)
//                        }
//                        return false
//                    }
//                })
//            }
//        )
//
//        // 2) The Center Pin Composable
//        Image(
//            painter = painterResource(R.drawable.google_logo), // your pin asset
//            contentDescription = "Center Pin",
//            modifier = Modifier
//                .align(Alignment.Center)
//                .size(48.dp)
//        )
//    }
//}
