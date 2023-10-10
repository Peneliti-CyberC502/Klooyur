package com.umn.kopicyber.klooyur.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItems = listOf(
    NavItem(
        label = "Home",
        icon = Icons.Default.Home,
        route = Pagees.HomePage.name
    ),
    NavItem(
        label = "Explore",
        icon = Icons.Default.LocationOn,
        route = Pagees.ExplorePage.name
    ),
    NavItem(
        label = "Profile",
        icon = Icons.Default.Person,
        route = Pagees.ProfilePage.name
    )
)