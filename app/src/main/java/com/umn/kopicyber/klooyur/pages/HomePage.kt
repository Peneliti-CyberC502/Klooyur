package com.umn.kopicyber.klooyur.pages
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card

@Composable
fun HomePage() {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

        ) {
            Box(){
                Image(
                    painter = painterResource(id = R.drawable.kopinako),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                    )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .align(Alignment.BottomCenter),
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Box(
                        modifier = Modifier.background(Color(0xFFB3261E),
                            shape = RoundedCornerShape(8.dp))
                    ) {
                        Text("NEXT DESTINATION",
                            fontWeight = FontWeight.W700,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp))
                    }
                    Text("Kopi Nako Monas",
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 32.sp,
                        color = Color.White)
                    Text("4 Trips Left",
                        fontWeight = FontWeight.W700,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.LightGray,
                        fontSize = 18.sp,)
                }
            }
        }

        Text("My Plans",
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontSize = 24.sp,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp))
        Column {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.myplans),
                        contentDescription = "Profile Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.height(75.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = "Jalan Jalan Gabut",
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            text = "12 Destination",
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                            color = Color(0xFFB69DF8),

                        )
                        Text(
                            text = "28 - 30 October 2023",
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    }
}