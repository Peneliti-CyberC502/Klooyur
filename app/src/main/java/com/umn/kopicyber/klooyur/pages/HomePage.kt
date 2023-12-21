package com.umn.kopicyber.klooyur.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.umn.kopicyber.klooyur.R
import com.umn.kopicyber.klooyur.navigations.Pagees
import com.umn.kopicyber.klooyur.viewmodels.HomeViewModel
import kotlinx.coroutines.flow.firstOrNull


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainPage(
    navController: NavHostController
) {
    // Buat navigasi di MainPage doang
    val localNavController = rememberNavController()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(route = Pagees.AddTripPage.name)
                },
                modifier = Modifier,
            ) {
                Icon(Icons.Filled.Add, "Small floating action button.")
            }
        },
        contentWindowInsets = WindowInsets(0.dp),
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 48.dp, bottom = 20.dp)
                    .zIndex(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var selectedTabIndex by remember { mutableIntStateOf(0) }

                // TODO: bikin custom TabRow biar ga kelebaran
                TabRow(
                    modifier = Modifier.width(250.dp),
                    selectedTabIndex = selectedTabIndex,
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.onBackground,
                    divider = {},
                    indicator = {}
                ) {
                    Tab(text = {
                        Text(
                            "Trips",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                        )
                    },
                        unselectedContentColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.65f),
                        selected = selectedTabIndex == 0,
                        onClick = {
                            selectedTabIndex = 0
                            localNavController.navigate(Pagees.HomePage.name)
                        })
                    Tab(text = {
                        Text(
                            "History",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                        )
                    },
                        unselectedContentColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.65f),
                        selected = selectedTabIndex == 1,
                        onClick = {
                            selectedTabIndex = 1
                            localNavController.navigate(Pagees.HistoryPage.name)
                        })
                }
            }
            NavHost(
                navController = localNavController,
                startDestination = Pagees.HomePage.name
            ) {
                composable(Pagees.HomePage.name) {
                    HomePage(navController, HomeViewModel())
                }
                composable(Pagees.HistoryPage.name) {
                    HistoryPage()
                }
            }

        }

    }
}

@Composable
fun HomePage(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
//                .padding(paddingValues)
    ) {
        CurrentTrip()
        /**
         * TRENDING NOW Section
         * Sementara di comment dulu karena belum ada data
         */

//            Text(
//                text = "Trending Now",
//                modifier = Modifier
//                    .padding(start = 20.dp, top = 16.dp, bottom = 16.dp),
//
//                style = TextStyle(
//                    fontSize = 16.sp,
//                    lineHeight = 24.sp,
//                    fontWeight = FontWeight(500),
//                    letterSpacing = 0.15.sp,
//                )
//            )
//
//            LazyRow(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 20.dp, top = 6.dp, bottom = 5.dp)
//            ) {
//                TODO: Ganti jadi data dari API
//            }


        Text(
            text = "Your Plans",
            modifier = Modifier
                .padding(start = 20.dp, top = 16.dp, bottom = 16.dp),
            style = MaterialTheme.typography.headlineSmall
        )


//        CardPlan(navController, "coba", 10)
//        CardPlan(navController, "Jalan Jalan Gabut", 12)
//        CardPlan(navController, "Coba", 3)
//        CardPlan(navController, "UMN", 30)

        val list = homeViewModel.state.value.list
        val routes = homeViewModel.state.value.routes


//        for (trip in list) {
//            CardPlan(navController, trip.title, routes.size)
//        }

        for (trip in list) {
            var routeSize by remember { mutableIntStateOf(0) }

            LaunchedEffect(trip.listId) {
                val routeList = homeViewModel.getAllRoutesFromId(trip.listId).firstOrNull()
                routeSize = routeList?.size ?: 0
            }

            CardPlan(navController, trip.listId, trip.title, routeSize)
        }



        Spacer(modifier = Modifier.weight(1f))
    }

}

@Composable
fun CurrentTrip() {
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, MaterialTheme.colorScheme.background),
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    )

    Box(
        Modifier
            .fillMaxWidth()
            .height(280.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.kopinako),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient)
                    }
                },

            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.errorContainer,
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
                        color = MaterialTheme.colorScheme.onErrorContainer
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
}


@Composable
fun CardTrending(name: String, title: String, destination: String) {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color.Transparent,
            MaterialTheme.colorScheme.background
        ),
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    )
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(end = 10.dp)
    ) {
        /* IMAGE */
        Box(
            Modifier
                .width(200.dp)
                .height(140.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.fototranding),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .drawWithCache {

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

            /* USERNAME of the trips */
            Text(
                text = name,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(500),
                    letterSpacing = 0.5.sp,
                ),
            )
        }

        /* TITLE of the trips */
        Text(
            text = title,
            modifier = Modifier
                .padding(top = 8.dp),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                letterSpacing = 0.1.sp,
            )
        )

        /* MAIN PLACE of the trips */
        Text(
            text = destination,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
            )
        )

    }


}

@Composable
fun CardPlan(navController: NavController, tripId: Int, title: String, destination: Int) {
    // Define the gradient
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            MaterialTheme.colorScheme.onPrimary,
            MaterialTheme.colorScheme.background
        ),
        startX = 0f,
        endX = Float.POSITIVE_INFINITY
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 5.dp, end = 20.dp, bottom = 5.dp)
            .clickable {
                navController.navigate(
                    "${Pagees.PlaylistPage.name}/$tripId"
                )
            }

    ) {
        Image(
            painter = painterResource(id = R.drawable.kopinako),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(88.dp)
                .clip(RoundedCornerShape(10.dp))
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            gradient,
                            blendMode = BlendMode.Multiply,
                            alpha = 0.75f
                        )
                    }
                },
            contentScale = ContentScale.Crop
        )

        // Main Content on top of the image
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 20.dp, end = 16.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 22.sp,
                        lineHeight = 28.sp,
                        fontWeight = FontWeight(700),
                    )
                )

                Text(
                    text = "$destination Destinations",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                        letterSpacing = 0.25.sp,
                    )
                )

            }
            Image(
                painter = painterResource(id = R.drawable.trip_arrow),
                contentDescription = null,
            )

        }

    }
}
