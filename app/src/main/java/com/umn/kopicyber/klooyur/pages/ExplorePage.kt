package com.umn.kopicyber.klooyur.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.umn.kopicyber.klooyur.R


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ExplorePage() {
    val UMN = LatLng(-6.256703722094951, 106.61839073819928)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(UMN, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = UMN),
            title = "Universitas Multimedia Nusantara",
            snippet = "Marker in Universitas Multimedia Nusantara"
        )
    }
        BottomSheetScaffold(
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 0.dp),

            sheetContent = {
                Column (
                    modifier = Modifier
                        .padding(16.dp, 0.dp, 16.dp, 0.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    NextTrip()
                    CardContent()
                    CardContent()
                    CardContent()
                    CardContent()

                }

            },
        sheetContainerColor = androidx.compose.ui.graphics.Color(0xFF2B2930),

        ) { }
    }


//@Preview
@Composable
fun NextTrip(
    backgroundColor: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color(0xFF211F26),
) {
    Column (
        modifier = Modifier
        .background(
            color = backgroundColor,
            shape = RoundedCornerShape(16.dp)
        ),

        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column (
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp, 0.dp)
                .align(Alignment.Start),

            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "NEXT Destination",
                fontFamily = FontFamily.SansSerif,
                color = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
                fontSize = 10.sp,
            )

            Row {
                Text(
                    text = "24 min ",
                    fontFamily = FontFamily.SansSerif,
                    color = androidx.compose.ui.graphics.Color(0xFFB69DF8),
                    fontSize = 20.sp,
                    )
                Text(
                    text = "(18 km)",
                    fontFamily = FontFamily.SansSerif,
                    color = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
                    fontSize = 20.sp

                )
            }
        }

        Divider(
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .align(Alignment.Start),
            color = androidx.compose.ui.graphics.Color(0xFFCAC4D0),
            thickness = 1.dp
        )

        Column (
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 16.dp)
                .align(Alignment.Start),

            verticalArrangement = Arrangement.spacedBy(10.dp)

        ) {
            Text(

                text = "Dufan Ancol (Dunia Fantasi)",
                color = androidx.compose.ui.graphics.Color(0xFFFFFFFF)
            )
            Text(
                text = "Jl. Lodan Timur No.7, Ancol, Kec. Pademangan, Jkt Utara, Daerah Khusus Ibukota Jakarta 14430, Indonesia",
                color = androidx.compose.ui.graphics.Color(0xFF958DA5)
            )
        }


    }
}



@Composable
fun CardContent() {
    Column (
        modifier = Modifier
            .padding(16.dp, 16.dp, 16.dp, 0.dp)

    ) {

        Text(
            text = "Dufan Ancol (Dunia Fantasi)",
            color = androidx.compose.ui.graphics.Color(0xFFFFFFFF))

        Text(text = "Jl. Lodan Timur No.7, Ancol, Kec. Pademangan, Jkt Utara, Daerah Khusus Ibukota Jakarta 14430, Indonesia",
            color = androidx.compose.ui.graphics.Color(0xFFFFFFFF))

        Batas()

    }

 }


@Composable
fun Batas() {
//    make box containing icon location and text 14km
    Row {

        Row (
            modifier = Modifier
                .padding(10.dp)
                .background(
                    color = androidx.compose.ui.graphics.Color(0xFF2B2930),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp)
        ) {

            Icon(
                Icons.Default.LocationOn,
                contentDescription = "Location",
                tint = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
                modifier = Modifier.size(15.dp)

            )

            Text(
                text = "14 km",
                fontFamily = FontFamily.SansSerif,
                color = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
                fontSize = 10.sp,
            )
        }

        Row (
            modifier = Modifier
                .padding(10.dp)
                .background(
                    color = androidx.compose.ui.graphics.Color(0xFF2B2930),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp)
        ) {

            Icon(
                painter = painterResource(R.drawable.schedule),
                contentDescription = "Location",
                tint = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
                modifier = Modifier.size(15.dp)
                )

            Text(
                text = "8 Minutes",
                fontFamily = FontFamily.SansSerif,
                color = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
                fontSize = 10.sp,
            )
        }

    }

}