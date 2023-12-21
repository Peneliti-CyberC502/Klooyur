package com.umn.kopicyber.klooyur
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.google.android.libraries.places.api.Places
import com.umn.kopicyber.klooyur.navigations.AppNavigation
import com.umn.kopicyber.klooyur.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Buat fullscreen
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(Color.Transparent.toArgb()))
        Places.initialize(this, BuildConfig.MAPS_API_KEY)
        super.onCreate(savedInstanceState)

        setContent{
            // Aplikasikan tema
            AppTheme(useDarkTheme = true) { AppNavigation() }
        }
    }
}