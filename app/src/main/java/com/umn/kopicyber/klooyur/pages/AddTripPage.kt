package com.umn.kopicyber.klooyur.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.umn.kopicyber.klooyur.database.Trips
import com.umn.kopicyber.klooyur.viewmodels.HomeViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun AddTripPage(
    navController: NavController,
    homeViewModel: HomeViewModel
) {
//    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
//    val tripState = homeViewModel.state.value

    Column {
        Text(text = "Nama Perjalanan")


        var title by remember { mutableStateOf(TextFieldValue("")) }
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        TextField(
            value = title,
            onValueChange = {
                title = it
            },
            label = { Text(text = "Jalan-Jalan Gabut") },
            placeholder = { Text(text = "") },
        )


        Row(
            modifier = androidx.compose.ui.Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text(text = "Batal")
            }

            Button(onClick = {

                val newTripTitle = title.text
                if (newTripTitle.isNotBlank()) {
                    val formattedDateTime = currentDateTime.format(formatter)
                    val newTrip = Trips(title = newTripTitle, desc = "aaa", startdate = formattedDateTime)
                    homeViewModel.insertList(newTrip)
                    navController.popBackStack()
                }


            }) {
                Text(text = "Buat")
            }

        }

    }
}
