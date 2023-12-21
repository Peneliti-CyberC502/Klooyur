package com.umn.kopicyber.klooyur.database

import android.content.Context

object Graph {
    lateinit var db: TripsRoutesDatabase
        private set

    val localDBRepository by lazy {
        LocalDBRepository(
            listDao = db.listDao(),
            routesDao = db.routesDao()
        )
    }

    fun provide(context: Context) {
        db = TripsRoutesDatabase.getDatabase(context)
    }

}