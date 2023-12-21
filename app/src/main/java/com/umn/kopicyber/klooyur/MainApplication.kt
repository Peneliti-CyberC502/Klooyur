package com.umn.kopicyber.klooyur

import android.app.Application
import com.google.android.libraries.places.api.Places
import com.umn.kopicyber.klooyur.database.Graph
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Inisialisasi Graph
        Graph.provide(this)
        // Inisialisasi Places API
        Places.initializeWithNewPlacesApiEnabled(this, BuildConfig.MAPS_API_KEY)
    }
}