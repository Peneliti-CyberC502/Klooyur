package com.umn.kopicyber.klooyur.navigations

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.umn.kopicyber.klooyur.pages.HomePage
import com.umn.kopicyber.klooyur.pages.ExplorePage
import com.umn.kopicyber.klooyur.pages.ProfilePage
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import com.umn.kopicyber.klooyur.pages.AddTripPage
import com.umn.kopicyber.klooyur.pages.HistoryPage
import com.umn.kopicyber.klooyur.pages.PlaylistPage
import com.umn.kopicyber.klooyur.viewmodels.HomeViewModel

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

                listOfNavItems.forEach{ navItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                        onClick = {
                            navController.navigate(navItem.route){
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
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Pagees.HomePage.name,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            composable(route = Pagees.HomePage.name) {
                HomePage(navController = navController)
            }
            composable(route = Pagees.ExplorePage.name) {
                ExplorePage()
            }
            composable(route = Pagees.ProfilePage.name) {
                ProfilePage()
            }
            composable(route = Pagees.HistoryPage.name) {
                HistoryPage(navController = navController)
            }
            composable(route = Pagees.PlaylistPage.name) {
                PlaylistPage(navController = navController)
            }
            composable(route = Pagees.AddTripPage.name) {
                AddTripPage(navController = navController, homeViewModel = homeViewModel)
            }
        }
    }
}