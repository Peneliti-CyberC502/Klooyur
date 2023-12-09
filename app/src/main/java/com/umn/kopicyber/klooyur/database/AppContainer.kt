package com.umn.kopicyber.klooyur.database

import android.app.Application
import android.content.Context

//interface AppContainer {
//    val repository: Repository
//}
//
//class AppDataContainer(private val context: Context) : AppContainer {
//    override val repository: Repository by lazy {
//        OfflineRepository(TripsRoutesDatabase.getDatabase(context).listDao(), TripsRoutesDatabase.getDatabase(context).routesDao())
//    }
//}
//


class AppContainer:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}




