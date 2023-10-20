package com.umn.kopicyber.klooyur.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.umn.kopicyber.klooyur.R

@Composable
fun LoginPage()
{
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {


                Image(
                    painter = painterResource(R.drawable.loginimage),
                    contentDescription = "Login Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .drawWithCache {
                            val gradient = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black),
                                startY = size.height / 3,
                                endY = size.height
                            )
                            onDrawWithContent {
                                drawContent()
                                drawRect(gradient, blendMode = BlendMode.Multiply)
                            }
                        },
                    contentScale = ContentScale.Crop
                )



        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .alpha(0.87f)
                .padding(30.dp)

        ) {
            Text(
                text = "Selamat Datang di",
                color = Color.White,
                fontSize = 20.sp,
            )
            Text(text = "Klooyur", fontSize = 53.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic , color = Color.White)

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google Icon",
                    tint = Color.Unspecified
                )

                Spacer(modifier = Modifier.padding(start = 10.dp))

                Text(
                    text = "Continue with Google",
                    color = Color.Black,
                    modifier = Modifier
                        .alpha(0.54f)
                )

            }

        }


    }
}