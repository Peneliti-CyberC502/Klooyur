package com.umn.kopicyber.klooyur.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.umn.kopicyber.klooyur.navigations.Pagees
import com.umn.kopicyber.klooyur.viewmodels.TripDetailViewModel
import com.umn.kopicyber.klooyur.viewmodels.TripDetailViewModelFactory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaylistPage(
    navController: NavController, tripId: Int
) {
    val viewModel = viewModel<TripDetailViewModel>(factory = TripDetailViewModelFactory(tripId))
    // get trip data
    val tripData = viewModel.state

    Scaffold(
        modifier = Modifier.fillMaxHeight(),
        topBar = {
            val scrollBehavior =
                TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

            LargeTopAppBar(title = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = tripData.title,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .height(50.dp)
                            .width(50.dp)
                            .clip(RoundedCornerShape(20)),
                    ) {
                        Icon(Icons.Filled.PlayArrow, "Play Button for Current Trip")
                    }

                }

            }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            }, actions = {
                Box {
                    var expandMenu by remember { mutableStateOf(false) }
                    IconButton(onClick = { expandMenu = true }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                    DropdownMenu(
                        expanded = expandMenu,
                        onDismissRequest = { expandMenu = false },
                    ) {
                        DropdownMenuItem(
                            text = {
                                Text(
                                    "Edit Trip",
                                    color = MaterialTheme.colorScheme.onBackground,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            },
                            onClick = { /*TODO*/ },
                        )
                    }
                }
            }, colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer
            ), scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(
                        "${Pagees.AddRoutePage.name}/$tripId"
                    )
                },
                modifier = Modifier.padding(start = 16.dp),
            ) {
                Icon(Icons.Filled.Add, "Small floating action button.")
            }
        },
        contentWindowInsets = WindowInsets(0.dp),

        ) { paddingValues ->
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(paddingValues)
        ) {
            items(tripData.routes) { route ->
                ListItem(
                    headlineContent = {
                        Text(
                            text = route.placeTitle,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    supportingContent = {
                        Text(
                            text = route.startTime,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .height(80.dp)
                        .width(80.dp)
                        .padding(start = 16.dp),
                    trailingContent = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.Delete,
                                contentDescription = "Delete Route"
                            )
                        }
                    }
                )

                /** NOTE:
                 * sebenernya composable ini udah deprecated diganti dengan HorizontalDivider
                 * cuma entah kenapa si bambang gabisa di import, makanya pakai ini aja :D
                 */
                Divider()
            }
        }
    }
}


