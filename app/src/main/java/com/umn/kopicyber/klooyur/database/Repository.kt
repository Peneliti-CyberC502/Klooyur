package com.umn.kopicyber.klooyur.database


class Repository (
    private val listDao: ListDao,
    private val routesDao: RoutesDao

) {

    val allList = listDao.getAllList()
    val allRoute = routesDao.getAllRoute()

    fun getListId(listIds: Int) = listDao.getListId(listIds)
    fun getRouteId(routesIds: Int) = routesDao.getRouteId(routesIds)

    suspend fun insertList(trips: Trips) = listDao.insertList(trips)
    suspend fun insertRoute(routes: Routes) = routesDao.insertRoute(routes)

    suspend fun updateList(trips: Trips) = listDao.updateList(trips)
    suspend fun updateRoute(routes: Routes) = routesDao.updateRoute(routes)

    suspend fun deleteList(trips: Trips) = listDao.deleteList(trips)
    suspend fun deleteRoute(routes: Routes) = routesDao.deleteRoute(routes)






//    fun getAllList(): Flow<List<Trips>> {}
//
//    fun getAllRoute(): Flow<List<Routes>>
//
//    fun getListId(listIds: IntArray): Flow<List<Trips>>
//
//    fun getRouteId(routesIds: IntArray): Flow<List<Routes>>
//
//    suspend fun insertList(trips: Trips)
//
//    suspend fun insertRoute(routes: Routes)
//
//    suspend fun updateList(trips: Trips)
//
//    suspend fun updateRoute(routes: Routes)
//
//    suspend fun deleteList(trips: Trips)
//
//    suspend fun deleteRoute(routes: Routes)



}

