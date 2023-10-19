package com.umn.kopicyber.klooyur
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import com.umn.kopicyber.klooyur.navigations.AppNavigation
import com.umn.kopicyber.klooyur.pages.LoginPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
//            AppNavigation()
            LoginPage()
        }
    }
}