package com.umn.kopicyber.klooyur.database

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow


class Repository(private val listDao: ListDao, private val routesDao: RoutesDao) {

    val allList: LiveData<List<Trips>> = listDao.getAllList()
    val allRoutes: LiveData<List<Routes>> = routesDao.getAllRoute()

    suspend fun insertList(trips: Trips) {
        listDao.insertList(trips)
    }

    suspend fun insertRoute(routes: Routes) {
        routesDao.insertRoute(routes)
    }

    suspend fun updateList(trips: Trips) {
        listDao.updateList(trips)
    }

    suspend fun updateRoute(routes: Routes) {
        routesDao.updateRoute(routes)
    }

    suspend fun deleteList(trips: Trips) {
        listDao.deleteList(trips)
    }

    suspend fun deleteRoute(routes: Routes) {
        routesDao.deleteRoute(routes)
    }

    suspend fun getListId(listIds: IntArray): LiveData<List<Trips>> {
        return listDao.getListId(listIds)
    }

    suspend fun getRouteId(routesIds: IntArray): LiveData<List<Routes>> {
        return routesDao.getRouteId(routesIds)
    }

}

