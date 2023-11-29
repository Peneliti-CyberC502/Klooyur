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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.umn.kopicyber.klooyur.R

@Composable
fun HomePage() {

    Column (
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black)
    ) {

        Box(){
                Image(
                    painter = painterResource(id = R.drawable.kopinako),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(),
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
                        modifier = Modifier.background(
                            Color(0xFFB3261E),
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


        Text(
            text = "Trending Now",

            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
//                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500),
                color = Color(0xFFEADDFF),
                letterSpacing = 0.15.sp,
            )
        )


        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 5.dp, end = 16.dp, bottom = 5.dp)
        ) {
            item {
                CardTranding("itshiroto", "Jalan Jalan Gabut", "Jakarta, Indonesia")
            }
            item {
                CardTranding("Ivan", "Coba", "Tangerang, Indonesia")
            }
            item {
                CardTranding("itshiroto", "Jalan Jalan Gabut", "Jakarta, Indonesia")
            }
            item {
                CardTranding("Ivan", "Coba", "Tangerang, Indonesia")
            }
            item {
                CardTranding("itshiroto", "Jalan Jalan Gabut", "Jakarta, Indonesia")
            }
            item {
                CardTranding("Ivan", "Coba", "Tangerang, Indonesia")
            }
        }


        Text("Your Plans",
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp))

        CardPlan("coba", 10)
        CardPlan("Jalan Jalan Gabut", 12)




    }



}


@Composable
fun CardTranding(name: String, title: String, destination: String) {

    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 16.dp, top = 5.dp, end = 16.dp, bottom = 5.dp)
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
            .padding(start = 16.dp, top = 5.dp, end = 16.dp, bottom = 5.dp)

    ){


        Image(
            painter = painterResource(id = R.drawable.kopinako),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(88.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillBounds
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

