package com.umn.kopicyber.klooyur.pages

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults

import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.umn.kopicyber.klooyur.R
import com.umn.kopicyber.klooyur.database.Routes
import com.umn.kopicyber.klooyur.database.Trips
import com.umn.kopicyber.klooyur.viewmodels.HomeViewModel


@Composable
fun FormPage(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    Column (
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(androidx.compose.ui.graphics.Color.Black)

    ) {
        Text(
            text = "Rencana Pergi",
            color = androidx.compose.ui.graphics.Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        )

        var textRencana by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = textRencana,
            label = { Text(text = "Jam") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { it ->
                textRencana = it
            },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        )

        var inputTanggal by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            singleLine = true,
            value = inputTanggal,
            onValueChange = {
                inputTanggal = it
            },
            label = { Text(text = "Tanggal Pergi") },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.date), // Replace with your icon resource
                    contentDescription = "Calendar Icon"

                )
            },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        )


//        make date picker from material 3
//        make time picker from material 3


        var inputAlamat by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = inputAlamat,
            label = { Text(text = "Alamat Pergi") },
            onValueChange = {
                inputAlamat = it
            },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        )

        Button(
            onClick = {

                val newRouteTime = textRencana.text
                val newRouteDate = inputTanggal.text
                val newRouteAddress = inputAlamat.text

                if (newRouteTime.isNotBlank() && newRouteDate.isNotBlank() && newRouteAddress.isNotBlank()) {
                    val newRoute = Routes(
                        tripsid = 1,
                        placeid = newRouteTime,
                        photos = "hello world",
                        placetitle = newRouteAddress,
                        startdate = newRouteDate,
                        order = 1
                    )
                    homeViewModel.insertRoute(newRoute)
                    navController.popBackStack()
                }


            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF6750A4),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(
                text = "Tambahkan Perjalanan!",
                color = Color.White,
            )

        }

    }
    
    
    
}



