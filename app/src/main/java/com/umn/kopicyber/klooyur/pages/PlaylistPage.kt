package com.umn.kopicyber.klooyur.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.umn.kopicyber.klooyur.R

@Preview
@Composable
fun PlaylistPage() {

    Column (
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            Modifier
                .fillMaxWidth()
                .height(241.dp)

        ){
            Image(
                painter = painterResource(R.drawable.loginimage),
                contentDescription = "Login Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .drawWithCache {
                        val gradient = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = size.height / 2.5f,
                            endY = size.height
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient, blendMode = BlendMode.Multiply)
                        }
                    },
                contentScale = ContentScale.Crop
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(start = 16.dp, bottom = 34.dp, end = 34.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

            Column{
                Text(
                    text = "Jalan-Jalan Gabut",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFE6E0E9),
                    )
                )
                Text(
                    text = "BY TONO HASTONO",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF958DA5),
                    )
                )
            }

                SmallFloatingActionButton(
                    onClick = {  },
                    modifier = Modifier
//                        make bottom end
                        .padding(start = 16.dp),


                    containerColor = Color(0xFF2B2930),
                    contentColor = Color(0xFFD0BCFF)
                ) {
                    Icon(Icons.Filled.Add, "Small floating action button.")
                }

            }


        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = "Belum ada destinasi.\nPilih destinasi sekarang!",
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 32.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFE6E0E9),
                ),
                textAlign = TextAlign.Center
            )
        }




    }




}


