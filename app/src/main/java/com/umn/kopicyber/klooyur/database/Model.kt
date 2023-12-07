package com.umn.kopicyber.klooyur.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "trips_list")
data class Trips(
    @PrimaryKey(autoGenerate = true)
    val list_id: Int = 0,
    val title: String,
    val desc: String,
    val startdate: String,
)

@Entity(tableName = "trips_routes", foreignKeys = [
    ForeignKey(
        entity = Trips::class,
        parentColumns = ["list_id"],
        childColumns = ["tripsid"],
        onDelete = ForeignKey.CASCADE
    )
])
data class Routes(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "routes_id")
    val routesid: Int = 0,
    val tripsid: Int,
    val placeid: String,
    val photos: String,
    val placetitle: String,
    val startdate: String,
    val order: Int,
)