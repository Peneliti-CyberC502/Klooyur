package com.umn.kopicyber.klooyur.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trips_list")
data class Trips(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "list_id")
    val id: Int = 0,
    val title: String,
    val desc: String,
    val startdate: String,
)

@Entity(tableName = "trips_routes")
data class Routes(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "routes_id")
    val id: Int = 0,
    val tripsid: Int,
    val placeid: String,
    val photos: String,
    val placetitle: String,
    val startdate: String,
    val order: Int,
    val listidFK: Int,
)