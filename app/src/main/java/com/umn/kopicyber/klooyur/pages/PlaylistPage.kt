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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.umn.kopicyber.klooyur.R
import com.umn.kopicyber.klooyur.navigations.Pagees
import com.umn.kopicyber.klooyur.viewmodels.HomeViewModel


@Composable
fun PlaylistPage(
    navController: NavController,
    homeViewModel: HomeViewModel = viewModel(),
    id: Int
) {

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
            Image(
                painter = painterResource(id = R.drawable.back_arrow),
                modifier = Modifier
                    .clickable {
                        navController.navigate(route = Pagees.HomePage.name)
                    },
                contentDescription = null,
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
                    onClick = {
                        navController.navigate(route = Pagees.FormPage.name)
                    },
                    modifier = Modifier
                        .padding(start = 16.dp),
                    containerColor = Color(0xFF2B2930),
                    contentColor = Color(0xFFD0BCFF)
                ) {
                    Icon(Icons.Filled.Add, "Small floating action button.")
                }

            }


        }



        val routeList by homeViewModel.getrouteId(id).collectAsState(initial = emptyList())

        for (route in routeList) {
            PlaylistCard(route.placetitle, route.startdate, route.placeid)
        }


    }

}


@Composable
fun PlaylistCard(title: String, time: String, address: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF36343B))
            .height(80.dp)
            .width(80.dp)
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(100))
        )


        Column(
            modifier = Modifier
//                .weight(1f)
                .padding(16.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {

            Text(
                text = title,
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFE6E0E9),
                    letterSpacing = 0.15.sp,
                )
            )

            Text(
                text = time,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFE6E0E9),
                    letterSpacing = 0.25.sp,
                )
            )
            }

            Text(
                text = address,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFE6E0E9),
                    letterSpacing = 0.25.sp,
                )
            )


        }



        Image(painter = painterResource(R.drawable.kopinako), contentDescription = null,
            modifier = Modifier
//                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
//                .clip(RoundedCornerShape(8.dp))
                .height(80.dp)
                .width(80.dp),
//                .shadow(4.dp),
            contentScale = ContentScale.FillBounds
        )
    }

}

