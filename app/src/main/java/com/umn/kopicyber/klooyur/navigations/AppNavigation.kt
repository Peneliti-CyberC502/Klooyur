package com.umn.kopicyber.klooyur.navigations

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.umn.kopicyber.klooyur.pages.AddRoutePage
import com.umn.kopicyber.klooyur.pages.AddTripPage
import com.umn.kopicyber.klooyur.pages.AddressAutoCompletePage
import com.umn.kopicyber.klooyur.pages.ExplorePage
import com.umn.kopicyber.klooyur.pages.MainPage
import com.umn.kopicyber.klooyur.pages.PlaylistPage
import com.umn.kopicyber.klooyur.pages.ProfilePage
import com.umn.kopicyber.klooyur.viewmodels.HomeViewModel
import com.umn.kopicyber.klooyur.viewmodels.TripDetailViewModel
import com.umn.kopicyber.klooyur.viewmodels.TripDetailViewModelFactory

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                // List of all the navigation items
                // TODO: improve performance untuk pindah page

                listOfNavItems.forEach { navItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                        onClick = {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = null
                            )
                        },
                        label = { Text(text = navItem.label) }
                    )
                }
            }
        },
        // Hapus padding di bawah dan atas biar keliatan fullscreen
        contentWindowInsets = WindowInsets(0.dp),
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Pagees.HomePage.name,
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues)
        ) {
            composable(route = Pagees.HomePage.name) {
//                HomePage(navController = navController, homeViewModel = homeViewModel)
                MainPage(navController = navController)
            }
            composable(route = Pagees.ExplorePage.name) {
                ExplorePage()
            }
            composable(route = Pagees.ProfilePage.name) {
                ProfilePage()
            }
//            composable(route = Pagees.HistoryPage.name) {
//                HistoryPage(navController = navController)
//            }
            composable(
                route = Pagees.PlaylistPage.name + "/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getInt("id")
                id?.let { PlaylistPage(navController = navController, tripId = it) }
            }


            composable(route = Pagees.AddTripPage.name) {
                AddTripPage(navController = navController, homeViewModel = homeViewModel)
            }
            composable(
                route = Pagees.AddRoutePage.name + "/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getInt("id")
                val tripDetailViewModel =
                    viewModel<TripDetailViewModel>(factory = TripDetailViewModelFactory(id!!))

                AddRoutePage(
                    tripId = id,
                    insertRoute = { route -> tripDetailViewModel.insertRoute((route)) },
                    routesCount = tripDetailViewModel.state.routes.size,
                    navController = navController,
                )
            }
            
            composable(
                // TODO: ganti penamaan routenya (taruh di pagees)
                route = "findRoute"
            ) {
                AddressAutoCompletePage(navController = navController)
            }
        }
    }
}