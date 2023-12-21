package com.umn.kopicyber.klooyur.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimeInput
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.umn.kopicyber.klooyur.database.Routes
import java.text.SimpleDateFormat
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRoutePage(
    tripId: Int,
    insertRoute: (routes: Routes) -> Unit,
    routesCount: Int,
    navController: NavController
) {
    val dateState = rememberDatePickerState(initialDisplayMode = DisplayMode.Picker)
    val timeState = rememberTimePickerState(is24Hour = true)
    val selectedDate = dateState.selectedDateMillis?.let { convertMillisToDate(it) }
    val selectedTime = "${timeState.hour}:${timeState.minute}"
    val selectedAddress = remember { mutableStateOf("") }



    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        val isDateOpen = remember { mutableStateOf(false) }



        MediumTopAppBar(title = { Text("New Route") }, navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        })

        Column(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {

            /**
             * ADDRESS PICKER
             */
            TextField(modifier = Modifier
                .fillMaxWidth(),
//                .clickable {
//                        navController.navigate("findRoute")
//                },
//                enabled = false,
//                readOnly = true,
                value = selectedAddress.value,
                onValueChange = { selectedAddress.value = it },
                label = { Text("Address") },
                trailingIcon = { Icon(Icons.Filled.LocationOn, "") })

            /**
             * DATE PICKER
             */
            TextField(value = selectedDate ?: "",
                readOnly = true,
                enabled = false,
                onValueChange = {},
                singleLine = true,
                label = { Text(text = "Date to go") },
                trailingIcon = { Icon(Icons.Filled.DateRange, contentDescription = null) },
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    disabledTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    disabledIndicatorColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    disabledTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isDateOpen.value = true })
            if (isDateOpen.value) {
                DatePickerDialog(onDismissRequest = { isDateOpen.value = false }, confirmButton = {
                    TextButton(onClick = { isDateOpen.value = false }) { Text("OK") }
                }, dismissButton = {
                    TextButton(onClick = { isDateOpen.value = false }) { Text("Cancel") }
                }) { DatePicker(state = dateState) }
            }

            /**
             * TIME PICKER
             */

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "Time to go", modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                )
                TimeInput(state = timeState)
            }
            Spacer(Modifier.weight(1f))
            Button(
                onClick = {
                    addRouteToDB(
                        tripId = tripId,
                        routeCount = routesCount,
                        insertRoute = insertRoute,
                        selectedAddress = selectedAddress.value,
                        selectedDate = selectedDate ?: "",
                        selectedTime = selectedTime
                    )
                    navController.popBackStack()
                }, modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add")
            }
        }
    }
}


private fun addRouteToDB(
    tripId: Int,
    routeCount: Int,
    insertRoute: (routes: Routes) -> Unit,
    selectedAddress: String,
    selectedDate: String,
    selectedTime: String
) {
    // merge selectedDate and selectedTime to Date

    val route = Routes(
        tripsId = tripId,
        placeId = selectedAddress,
        placeTitle = selectedAddress,
        startTime = "$selectedDate $selectedTime",
        order = routeCount + 1
    )
    insertRoute(route)
}

private fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", java.util.Locale.getDefault())
    return formatter.format(Date(millis))
}



