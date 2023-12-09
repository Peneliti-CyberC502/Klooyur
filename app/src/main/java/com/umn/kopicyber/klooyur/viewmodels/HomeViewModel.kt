package com.umn.kopicyber.klooyur.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umn.kopicyber.klooyur.database.Graph
import com.umn.kopicyber.klooyur.database.Repository
import com.umn.kopicyber.klooyur.database.Routes
import com.umn.kopicyber.klooyur.database.Trips
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeViewModel(
    private val repository: Repository = Graph.repository
):ViewModel() {
    var state = mutableStateOf(HomeState())
        private set

    init {
      getlist()
        getroute()
    }

    private fun getroute() {
        viewModelScope.launch {
            repository.allRoute.collectLatest {
                state.value = state.value.copy(
                    routes = it
                )
            }
        }

    }

    fun getrouteId(id: Int) {
        viewModelScope.launch {
            repository.getRouteId(id).collectLatest {
                state.value = state.value.copy(
                    routes = it
                )
            }
        }
    }

    fun insertRoute(routes: Routes) {
        viewModelScope.launch {
            repository.insertRoute(routes)
        }
    }

    fun updateRoute(routes: Routes) {
        viewModelScope.launch {
            repository.updateRoute(routes)
        }
    }

    fun deleteRoute(routes: Routes) {
        viewModelScope.launch {
            repository.deleteRoute(routes)
        }
    }



    private fun getlist() {
        viewModelScope.launch {
            repository.allList.collectLatest {
                state.value = state.value.copy(
                    list = it
                )
            }
        }
    }

    fun deleteList(trips: Trips) {
        viewModelScope.launch {
            repository.deleteList(trips)
        }
    }

    fun updateList(trips: Trips) {
        viewModelScope.launch {
            repository.updateList(trips)
        }
    }

    fun insertList(trips: Trips) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.insertList(trips)
            }
        }
    }

    fun listId(id: Int) {
        viewModelScope.launch {
            repository.getListId(id).collectLatest {
                state.value = state.value.copy(
                    list = it
                )
            }
        }
    }

}

data class HomeState(
    val list: List<Trips> = emptyList(),
    val routes: List<Routes> = emptyList()
)

