package com.umn.kopicyber.klooyur.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.umn.kopicyber.klooyur.R
import com.umn.kopicyber.klooyur.navigations.Pagees

@Composable
fun HistoryPage(navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black)
    ) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 32.dp, end = 20.dp, bottom = 32.dp),
        horizontalArrangement = Arrangement.spacedBy(35.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.Top,
    ) {
        Text(
            text = "Trips",
            modifier = Modifier
                .clickable {
                    navController.navigate(route = Pagees.HomePage.name)
                },
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF4A4458),
            )
        )

        Text(
            text = "History",
            modifier = Modifier.drawBehind {
                val strokeWidthPx = 1.dp.toPx()
                val verticalOffset = size.height - 2.sp.toPx()
                drawLine(
                    color = Color(0xFFE6E0E9),
                    strokeWidth = strokeWidthPx,
                    start = Offset(0f, verticalOffset),
                    end = Offset(size.width, verticalOffset)
                )
            },

            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFE6E0E9),
            )
        )
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
//            .background(Color(0xFF1E1A21))
            .padding(start = 8.dp, end = 8.dp),


        content = {
            items(10) {
                CardHistory()
            }
        }
    )
    }

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