package com.umn.kopicyber.klooyur
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.umn.kopicyber.klooyur.navigations.AppNavigation
import com.umn.kopicyber.klooyur.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        ini masih janky bet implementasinya
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(Color.Transparent.toArgb()))
        super.onCreate(savedInstanceState)
        setContent{
            AppTheme(
                useDarkTheme = true
            ) {
                AppNavigation()
            }
        }
    }
}