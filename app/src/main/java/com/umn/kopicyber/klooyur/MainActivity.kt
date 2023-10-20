package com.umn.kopicyber.klooyur
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import com.umn.kopicyber.klooyur.navigations.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            AppNavigation()
        }
    }
}