package com.umn.kopicyber.klooyur.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.umn.kopicyber.klooyur.database.AppContainer
import com.umn.kopicyber.klooyur.database.Routes
import com.umn.kopicyber.klooyur.database.Trips
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel (private val appContainer: AppContainer) : ViewModel() {
    val repository = appContainer.repository
    val allList: LiveData<List<Trips>> = repository.getAllList().asLiveData()
    val allRoute: LiveData<List<Routes>> = repository.getAllRoute().asLiveData()
    val listId: LiveData<List<Trips>> = repository.getListId(intArrayOf(1)).asLiveData()
    val routeId: LiveData<List<Routes>> = repository.getRouteId(intArrayOf(1)).asLiveData()

    fun insertList(trips: Trips) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertList(trips)
    }

    fun insertRoute(routes: Routes) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertRoute(routes)
    }

    fun updateList(trips: Trips) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateList(trips)
    }

    fun updateRoute(routes: Routes) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateRoute(routes)
    }

    fun deleteList(trips: Trips) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteList(trips)
    }

    fun deleteRoute(routes: Routes) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteRoute(routes)
    }
}

