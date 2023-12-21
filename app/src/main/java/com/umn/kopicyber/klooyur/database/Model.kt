package com.umn.kopicyber.klooyur.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date


/**
 * trips_list
 *
 * list_id: id dari list
 * title: judul dari list
 * desc: deskripsi dari list
 * startdate: tanggal mulai dari list
 */
@Entity(tableName = "trips_list")
data class Trips(
    @PrimaryKey(autoGenerate = true)
    val listId: Int = 0,
    val title: String,
    val desc: String,
    val startDate: String,
)

/**
 * trips_routes
 *
 * routes_id: id dari route
 * tripsid: id dari list
 * placeid: id dari tempat
 * photos: foto dari tempat
 * placetitle: judul dari tempat
 * startdate: tanggal mulai dari tempat
 * order: urutan dari tempat
 */
@Entity(
    tableName = "trips_routes",
    foreignKeys = [ForeignKey(
        entity = Trips::class,
        parentColumns = ["listId"],
        childColumns = ["tripsId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Routes(
    @PrimaryKey
    val placeId: String,
    val placeTitle: String,
    val tripsId: Int,
    val startTime: String,
    val order: Int,
)