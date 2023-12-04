package com.umn.kopicyber.klooyur.database

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class TripsRoutesViewModel: ViewModel() {
    private val repository: Repository
    val allList: LiveData<List<Trips>>
    val allRoutes: LiveData<List<Routes>>

    init {
        val listDao = TripsRoutesDatabase.getDatabase(Application()).listDao()
        val routesDao = TripsRoutesDatabase.getDatabase(Application()).routesDao()
        repository = Repository(listDao, routesDao)
        allList = repository.allList
        allRoutes = repository.allRoutes
    }

    suspend fun insertList(trips: Trips) {
        repository.insertList(trips)
    }

    suspend fun insertRoute(routes: Routes) {
        repository.insertRoute(routes)
    }

    suspend fun updateList(trips: Trips) {
        repository.updateList(trips)
    }

    suspend fun updateRoute(routes: Routes) {
        repository.updateRoute(routes)
    }

    suspend fun deleteList(trips: Trips) {
        repository.deleteList(trips)
    }

    suspend fun deleteRoute(routes: Routes) {
        repository.deleteRoute(routes)
    }

    suspend fun getListId(listIds: IntArray): LiveData<List<Trips>> {
        return repository.getListId(listIds)
    }

    suspend fun getRouteId(routesIds: IntArray): LiveData<List<Routes>> {
        return repository.getRouteId(routesIds)
    }

}