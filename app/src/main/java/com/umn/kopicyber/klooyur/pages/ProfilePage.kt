package com.umn.kopicyber.klooyur.pages

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.umn.kopicyber.klooyur.R


@Composable
fun ProfilePage() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentAlignment = Alignment.Center,

        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Background profile",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()

            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp, top = 72.dp, bottom = 4.dp),
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.profile_image),
                        contentDescription = "Profile Image",
                        modifier = Modifier.size(75.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = "Tono Hastono",
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            text = "Traveller",
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                        )
                    }

                }
            }
        }



        Divider(
            modifier = Modifier
                .padding(top = 16.dp),
        )

        Column {
            ListItem(
                headlineContent = {
                    Text("My Account")
                },
//                supportingContent = {
//                    Text("Secondary text that is long and perhaps goes onto another line")
//                },
//                leadingContent = {
//                    Icon(
//                        Icons.Filled.Favorite,
//                        contentDescription = "Localized description",
//                    )
//                },
//                trailingContent = { Text("meta") }
            )
            Divider()

            ListItem(
                headlineContent = {
                    Text("Scheduled Plans")
                },
//                supportingContent = {
//                    Text("Secondary text that is long and perhaps goes onto another line")
//                },
//                leadingContent = {
//                    Icon(
//                        Icons.Filled.Favorite,
//                        contentDescription = "Localized description",
//                    )
//                },
//                trailingContent = { Text("meta") }
            )
            Divider()

            ListItem(
                headlineContent = {
                    Text("Favorites")
                },
//                supportingContent = {
//                    Text("Secondary text that is long and perhaps goes onto another line")
//                },
//                leadingContent = {
//                    Icon(
//                        Icons.Filled.Favorite,
//                        contentDescription = "Localized description",
//                    )
//                },
//                trailingContent = { Text("meta") }
            )
            Divider()
        }

        ListItem(
            headlineContent = {
                Text("Settings")
            },
//                supportingContent = {
//                    Text("Secondary text that is long and perhaps goes onto another line")
//                },
//                leadingContent = {
//                    Icon(
//                        Icons.Filled.Favorite,
//                        contentDescription = "Localized description",
//                    )
//                },
//                trailingContent = { Text("meta") }
        )
        Divider()

        ListItem(
            headlineContent = {
                Text("Language")
            },
//                supportingContent = {
//                    Text("Secondary text that is long and perhaps goes onto another line")
//                },
//                leadingContent = {
//                    Icon(
//                        Icons.Filled.Favorite,
//                        contentDescription = "Localized description",
//                    )
//                },
//                trailingContent = { Text("meta") }
        )
        Divider()

        ListItem(
            headlineContent = {
                Text("Feedback")
            },
//                supportingContent = {
//                    Text("Secondary text that is long and perhaps goes onto another line")
//                },
//                leadingContent = {
//                    Icon(
//                        Icons.Filled.Favorite,
//                        contentDescription = "Localized description",
//                    )
//                },
//                trailingContent = { Text("meta") }
        )
        Divider()

        ListItem(
            headlineContent = {
                Text("Help Center")
            },
//                supportingContent = {
//                    Text("Secondary text that is long and perhaps goes onto another line")
//                },
//                leadingContent = {
//                    Icon(
//                        Icons.Filled.Favorite,
//                        contentDescription = "Localized description",
//                    )
//                },
//                trailingContent = { Text("meta") }
        )
        Divider()

        ListItem(
            headlineContent = {
                Text("Logout")
            },
//                supportingContent = {
//                    Text("Secondary text that is long and perhaps goes onto another line")
//                },
//                leadingContent = {
//                    Icon(
//                        Icons.Filled.Favorite,
//                        contentDescription = "Localized description",
//                    )
//                },
//                trailingContent = { Text("meta") }
        )
        Divider()
    }
}