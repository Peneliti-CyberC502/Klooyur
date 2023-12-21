package com.umn.kopicyber.klooyur.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Trips::class, Routes::class], version = 5, exportSchema = false)
abstract class TripsRoutesDatabase : RoomDatabase() {
    abstract fun listDao(): ListDao
    abstract fun routesDao(): RoutesDao


    companion object {
        @Volatile
        private var Instance: TripsRoutesDatabase? = null

        fun getDatabase(context: Context): TripsRoutesDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TripsRoutesDatabase::class.java, "trips_routes_database")
                    .fallbackToDestructiveMigration()
                    .build().also {
                        Instance = it
                    }
            }
        }

    }


}