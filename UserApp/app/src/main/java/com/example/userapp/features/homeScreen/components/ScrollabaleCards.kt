package com.example.userapp.features.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.userapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ScrollableCards() {
    val images = listOf(
        painterResource(id = R.drawable.cards_1),
        painterResource(id = R.drawable.cards_2),
        painterResource(id = R.drawable.cards_3),
        painterResource(id = R.drawable.cards_4),
    )

    val pagerState = rememberPagerState(pageCount = { images.size })
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            val nextPage = (pagerState.currentPage + 1) % images.size
            coroutineScope.launch { pagerState.animateScrollToPage(nextPage) }
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 10.dp)
        ) { page ->
            ImageCard(images[page])
        }

        // Dots Indicator
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            images.indices.forEach { index ->
                Surface(
                    modifier = Modifier
                        .size(12.dp)
                        .padding(4.dp),
                    shape = androidx.compose.foundation.shape.CircleShape,
                    color = if (pagerState.currentPage == index) Color.Black else Color.Gray
                ) {}
            }
        }
    }
}

@Composable
fun ImageCard(image: Painter) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}
