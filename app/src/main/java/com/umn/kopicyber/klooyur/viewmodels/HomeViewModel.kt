package com.umn.kopicyber.klooyur.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umn.kopicyber.klooyur.database.Graph
import com.umn.kopicyber.klooyur.database.LocalDBRepository
import com.umn.kopicyber.klooyur.database.Routes
import com.umn.kopicyber.klooyur.database.Trips
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeViewModel(
    private val localDBRepository: LocalDBRepository = Graph.localDBRepository
) : ViewModel() {
    var state = mutableStateOf(HomeState())
        private set

    init {
        getlist()
        getRoute()
    }

    fun getAllRoutesFromId(id: Int): Flow<List<Routes>> {
        return localDBRepository.getAllRoutesFromId(id)
    }

    private fun getRoute() {
        viewModelScope.launch {
            localDBRepository.allRoute.collectLatest {
                state.value = state.value.copy(
                    routes = it
                )
            }
        }
    }

    private fun getlist() {
        viewModelScope.launch {
            localDBRepository.allList.collectLatest {
                state.value = state.value.copy(
                    list = it
                )
            }
        }
    }

    fun insertList(trips: Trips) {
        viewModelScope.launch {
            localDBRepository.insertList(trips)
        }
    }

}

data class HomeState(
    val list: List<Trips> = emptyList(),
    val routes: List<Routes> = emptyList()
)

