package com.umn.kopicyber.klooyur.database

import android.app.Application

class AppContainer:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}




