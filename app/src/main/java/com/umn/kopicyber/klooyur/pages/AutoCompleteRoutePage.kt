package com.umn.kopicyber.klooyur.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.umn.kopicyber.klooyur.maps.PlacesResult
import com.umn.kopicyber.klooyur.maps.PlacesSearchViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun AddressAutoCompletePage(
    navController: NavController
) {
    val viewModel = hiltViewModel<PlacesSearchViewModel>()
    val permission = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
    )

    val placesResult = viewModel.search.value

    val query = viewModel.query.collectAsState()



    Column {
        TopAppBar(
            title = {
                Text("Select Trip")
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            },
        )
        if (permission.allPermissionsGranted) {
            when (placesResult) {
                is PlacesResult.Idle -> {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Search for a place")
                    }
                }
                is PlacesResult.Loading -> {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Loading...")
                    }
                }

                is PlacesResult.Success -> {
                    OutlinedTextField(
                        value = query.value,
                        onValueChange = {
                            viewModel.updateQuery(it)
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(placesResult.list) {
                            // TODO: ganti jadi ListItem
                            Text(
                                text = it.getFullText(null).toString(),
                                modifier = Modifier.padding(8.dp).fillMaxWidth()
                            )
                        }
                    }
                    Spacer(Modifier.height(16.dp))
                }

                is PlacesResult.Error -> {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Error")
                    }
                }
            }
        } else run {
            LaunchedEffect(key1 = Unit, block = {
                permission.launchMultiplePermissionRequest()
            })
        }

    }
}
