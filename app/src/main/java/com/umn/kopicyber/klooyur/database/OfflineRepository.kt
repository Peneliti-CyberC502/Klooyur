package com.umn.kopicyber.klooyur.database

import kotlinx.coroutines.flow.Flow


//class OfflineRepository(private val listDao: ListDao, private val routesDao: RoutesDao): Repository {
//
//    override fun getAllList(): Flow<List<Trips>> = listDao.getAllList()
//
//    override fun getAllRoute(): Flow<List<Routes>> = routesDao.getAllRoute()
//
//    override fun getListId(listIds: IntArray): Flow<List<Trips>> = listDao.getListId(listIds)
//
//    override fun getRouteId(routesIds: IntArray): Flow<List<Routes>> = routesDao.getRouteId(routesIds)
//
//    override suspend fun insertList(trips: Trips) = listDao.insertList(trips)
//
//    override suspend fun insertRoute(routes: Routes) = routesDao.insertRoute(routes)
//
//    override suspend fun updateList(trips: Trips) = listDao.updateList(trips)
//
//    override suspend fun updateRoute(routes: Routes) = routesDao.updateRoute(routes)
//
//    override suspend fun deleteList(trips: Trips) = listDao.deleteList(trips)
//
//    override suspend fun deleteRoute(routes: Routes) = routesDao.deleteRoute(routes)
//
//
//
//
//
//}