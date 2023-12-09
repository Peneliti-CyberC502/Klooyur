package com.umn.kopicyber.klooyur.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ListDao {
    @Query("SELECT * FROM trips_list")
    fun getAllList(): Flow<List<Trips>>

    //    @Query("SELECT * FROM trips_list WHERE list_id IN (:listIds)")
    @Query("SELECT * FROM trips_list WHERE list_id =:listIds")
    fun getListId(listIds: Int): Flow<List<Trips>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(trips: Trips)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateList(trips: Trips)

    @Delete
    fun deleteList(trips: Trips)
}

@Dao
interface RoutesDao {
    @Query("SELECT * FROM trips_routes")
    fun getAllRoute(): Flow<List<Routes>>

    @Query("SELECT * FROM trips_routes WHERE tripsid = :listId")
    fun getRouteId(listId: Int): Flow<List<Routes>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRoute(vararg routes: Routes)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateRoute(vararg routes: Routes)

    @Delete
    fun deleteRoute(routes: Routes)
}