package com.umn.kopicyber.klooyur.pages

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.umn.kopicyber.klooyur.database.Trips
import com.umn.kopicyber.klooyur.viewmodels.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTripPage(
    navController: NavController,
    homeViewModel: HomeViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var title by remember { mutableStateOf(TextFieldValue("Jalan-Jalan Gabut")) }

        Text(
            text = "Insert your new trip title!",
            modifier = Modifier.padding(bottom = 16.dp),
            style = MaterialTheme.typography.bodyMedium,
        )
        TextField(
            value = title,
            onValueChange = {
                title = it
            },
            singleLine = true,
            textStyle = MaterialTheme.typography.headlineMedium.plus(
                TextStyle(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center

                )
            ),

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
            )
        )


        Row(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
        ) {
            OutlinedButton(
                modifier = Modifier
                    .padding(end = 8.dp),
                onClick = {
                    navController.popBackStack()
                }) {
                Text(text = "Cancel")
            }

            Button(
                onClick = {
                    val newTripTitle = title.text
                    if (newTripTitle.isNotBlank()) {
                        val newTrip = Trips(title = newTripTitle, desc = "aaa", startdate = "bbb")
                        homeViewModel.insertList(newTrip)
                        navController.popBackStack()
                    }


                }) {
                Text(text = "Buat")
            }

        }

    }
}

// Create preview
//@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
//    showSystemUi = true, showBackground = true
//)
//@Composable
//fun AddTripPagePreview() {
//    AddTripPage(navController = rememberNavController())
//}
