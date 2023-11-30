package com.umn.kopicyber.klooyur.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.umn.kopicyber.klooyur.R
import kotlin.math.ceil

@Composable
fun HistoryPage() {
//    CardHistory()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF1E1A21))
            .padding(start = 8.dp, end = 8.dp),


        content = {
            items(10) {
                CardHistory()
            }
        }
    )

}

@Composable
fun CardHistory() {

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
//            .wrapContentHeight()
            .padding(10.dp)
    ) {

        Box(
            Modifier
                .width(200.dp)
                .height(140.dp),
        ){
            Image(
                painter = painterResource(id = R.drawable.cardimage),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .drawWithCache {
                        val gradient = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF727272),
                                Color(0xFF000000)
                            ),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(
                                gradient,
                                blendMode = BlendMode.Multiply,
                                alpha = 0.5f
                            )
                        }
                    },
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.clipboard),
                modifier = Modifier
                    .align(Alignment.Center),
                contentDescription = null,
            )



        }

        Text(
            text = "Jalan Jalan Gabut",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFE6E0E9),
                letterSpacing = 0.15.sp,
            )
        )

        Text(
            text = "12 Destinations",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFB69DF8),
                letterSpacing = 0.1.sp,
            )
        )

        Text(
            text = "28 - 30 October 2023",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFFE6E0E9),
            )
        )

    }

}