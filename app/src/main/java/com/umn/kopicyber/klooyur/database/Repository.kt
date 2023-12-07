package com.umn.kopicyber.klooyur.database

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


interface Repository {

    fun getAllList(): Flow<List<Trips>>

    fun getAllRoute(): Flow<List<Routes>>

    fun getListId(listIds: IntArray): Flow<List<Trips>>

    fun getRouteId(routesIds: IntArray): Flow<List<Routes>>

    suspend fun insertList(trips: Trips)

    suspend fun insertRoute(routes: Routes)

    suspend fun updateList(trips: Trips)

    suspend fun updateRoute(routes: Routes)

    suspend fun deleteList(trips: Trips)

    suspend fun deleteRoute(routes: Routes)



}

