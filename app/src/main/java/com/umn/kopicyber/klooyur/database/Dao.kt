package com.umn.kopicyber.klooyur.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ListDao {
    @Query("SELECT * FROM trips_list")
    fun getAllList(): List<Trips>

    //    @Query("SELECT * FROM trips_list WHERE list_id IN (:listIds)")
    @Query("SELECT * FROM trips_list WHERE list_id =:listIds")
    fun getListId(listIds: IntArray): List<Trips>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(trips: Trips)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateList(trips: Trips)

    @Delete
    fun deleteList(trips: Trips)
}

@Dao
interface RoutesDao {
    @Query("SELECT * FROM trips_routes")
    fun getAllRoute(): List<Routes>

    @Query("SELECT * FROM trips_routes WHERE routes_id =:routesIds")
    fun getRouteId(routesIds: IntArray): List<Routes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoute(vararg routes: Routes)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateRoute(vararg routes: Routes)

    @Delete
    fun deleteRoute(routes: Routes)
}