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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.umn.kopicyber.klooyur.R
import com.umn.kopicyber.klooyur.navigations.Pagees

@Composable
fun HomePage() {

    Column (
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
//            .background(Color.Black)
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            Modifier
                .fillMaxWidth()
                .height(241.dp)

        ){
            Image(
                painter = painterResource(id = R.drawable.kopinako),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .drawWithCache {
                        val gradient = Brush.verticalGradient(
                            colors = listOf(Color(0xFF381E7240), Color(0xFF381E72E5)),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient, blendMode = BlendMode.SrcOver)
                        }
                    },

                contentScale = ContentScale.Crop
            )





            Column(
                Modifier
                    .shadow(
                        elevation = 2.dp,
                        spotColor = Color(0x4D000000),
                        ambientColor = Color(0x4D000000)
                    )
                    .shadow(
                        elevation = 6.dp,
                        spotColor = Color(0x26000000),
                        ambientColor = Color(0x26000000)
                    )
                    .padding(start = 20.dp, top = 32.dp, end = 20.dp, bottom = 32.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Bottom),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {


                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xFFB3261E),
                                shape = RoundedCornerShape(size = 25.dp)
                            )
                            .padding(start = 10.dp, top = 3.dp, end = 10.dp, bottom = 3.dp)
                    ) {
                        Text(
                            text = "Next Destination ",
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 16.sp,
                                fontWeight = FontWeight(800),
                                color = Color(0xFFFFFBFE),
                            )
                        )
                    }
                Text(
                    text = "Kopi Nako Monas",
                    style = TextStyle(
                        fontSize = 32.sp,
                        lineHeight = 40.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                    )
                )
                Text(
                    text = "JALAN JALAN GABUT - 4 Trips Left",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                        letterSpacing = 0.5.sp,
                    )
                )
                }



        }




        Text(
            text = "Trending Now",
            modifier = Modifier
                .padding(start = 20.dp, top = 16.dp, bottom = 16.dp),

            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFEADDFF),
                letterSpacing = 0.15.sp,
            )
        )


        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 6.dp, bottom = 5.dp)
        ) {
            item {
                CardTrending("itshiroto", "Jalan Jalan Gabut", "Jakarta, Indonesia")
            }
            item {
                CardTrending("Ivan", "Coba", "Tangerang, Indonesia")
            }
            item {
                CardTrending("itshiroto", "Jalan Jalan Gabut", "Jakarta, Indonesia")
            }
            item {
                CardTrending("Ivan", "Coba", "Tangerang, Indonesia")
            }
            item {
                CardTrending("itshiroto", "Jalan Jalan Gabut", "Jakarta, Indonesia")
            }
            item {
                CardTrending("Ivan", "Coba", "Tangerang, Indonesia")
            }
        }


        Text(
            text = "Your Plans",
            modifier = Modifier
                .padding(start = 20.dp, top = 16.dp, bottom = 16.dp),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFEADDFF),
                letterSpacing = 0.15.sp,
            )
        )


        CardPlan("coba", 10)
        CardPlan("Jalan Jalan Gabut", 12)
        CardPlan("Coba", 3)
        CardPlan("UMN", 30)

    }

}


@Composable
fun CardTrending(name: String, title: String, destination: String) {

    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(end = 10.dp)
    ) {

    Box(
        Modifier
            .width(200.dp)
            .height(140.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.fototranding),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF381E7200), // Warna pertama (#381E7200)
                            Color(0xFF000000)    // Warna kedua (#000000)
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            gradient,
                            blendMode = BlendMode.DstOut,
                            alpha = 0.5f
                        ) // Mengatur opacity menjadi 50%
                    }
                },
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp),
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFE6E0E9),

                letterSpacing = 0.5.sp,

            ),
        )

    }

        Text(
            text = title,
            modifier = Modifier
                .padding(top = 8.dp),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFE6E0E9),
                letterSpacing = 0.1.sp,
            )
        )

        Text(
            text = destination,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF958DA5),
            )
        )

    }


}


@Composable
fun CardPlan(title: String, destination: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 5.dp, end = 20.dp, bottom = 5.dp)

    ){

        Image(
            painter = painterResource(id = R.drawable.kopinako),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(88.dp)
                .clip(RoundedCornerShape(10.dp))
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF381E7200),
                            Color(0xFF000000)
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            gradient,
                            blendMode = BlendMode.DstOut,
                            alpha = 0.75f
                        )
                    }
                },
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 20.dp, end = 16.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
//                modifier = Modifier
//                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                text = title,
                style = TextStyle(
                    fontSize = 22.sp,
                    lineHeight = 28.sp,
//                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFE6E0E9),

                    )
            )
                Text(
                text = "$destination Destinations",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
//                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFE6E0E9),

                    letterSpacing = 0.25.sp,
                )
            )

            }
            Image(
                painter = painterResource(id = R.drawable.trip_arrow),
                contentDescription = null,
                )

        }




//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//                .align(Alignment.BottomCenter),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//
//            Row {
//
//            Text(
//                text = "Jalan Jalan Gabut",
//                style = TextStyle(
//                    fontSize = 22.sp,
//                    lineHeight = 28.sp,
////                    fontFamily = FontFamily(Font(R.font.roboto)),
//                    fontWeight = FontWeight(700),
//                    color = Color(0xFFE6E0E9),
//
//                    )
//            )
//            Text(
//                text = "12 Destinations",
//                style = TextStyle(
//                    fontSize = 14.sp,
//                    lineHeight = 20.sp,
////                    fontFamily = FontFamily(Font(R.font.roboto)),
//                    fontWeight = FontWeight(400),
//                    color = Color(0xFFE6E0E9),
//
//                    letterSpacing = 0.25.sp,
//                )
//            )
//            }
//
//            Image(
//                painter = painterResource(id = R.drawable.trip_arrow),
//                contentDescription = null,
//
//                )
//        }



    }
}

