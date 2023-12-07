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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun AddTripPage() {
    Column {
        Text(text = "Nama Perjalanan")

        InputText()


    }
}

@Composable
fun InputText() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
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
            //your onclick code here
        }) {
            Text(text = "Batal")
        }

        Button(onClick = {
            //your onclick code here
        }) {
            Text(text = "Buat")
        }

    }
}