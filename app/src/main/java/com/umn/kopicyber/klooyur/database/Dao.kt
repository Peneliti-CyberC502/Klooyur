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
    // Get all list from trips_list table
    @Query("SELECT * FROM trips_list")
    fun getAllList(): Flow<List<Trips>>

    // Get list from trips_list table based on list_id
    @Query("SELECT * FROM trips_list WHERE listId =:listIds")
    fun getListId(listIds: Int): Flow<List<Trips>>

    // Insert list to trips_list table
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertList(trips: Trips)

    // Update list in trips_list table
    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateList(trips: Trips)

    // Delete list from trips_list table
    @Delete
    fun deleteList(trips: Trips)
}

@Dao
interface RoutesDao {
    // Get all route from trips_routes table
    @Query("SELECT * FROM trips_routes")
    fun getAllRoute(): Flow<List<Routes>>

    // Get route from trips_routes table based on tripsid
    @Query("SELECT * FROM trips_routes WHERE tripsId = :listId")
    fun getAllRoutesFromId(listId: Int): Flow<List<Routes>>

    @Query("SELECT COUNT(*) FROM trips_routes WHERE tripsId = :listId")
    suspend fun getRoutesCount(listId: Int): Int

    // Insert route to trips_routes table
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRoute(vararg routes: Routes)

    // Update route in trips_routes table
    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateRoute(vararg routes: Routes)

    // Delete route from trips_routes table
    @Delete
    fun deleteRoute(routes: Routes)
}