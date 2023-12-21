package com.umn.kopicyber.klooyur.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.umn.kopicyber.klooyur.database.Graph
import com.umn.kopicyber.klooyur.database.LocalDBRepository
import com.umn.kopicyber.klooyur.database.Routes
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TripDetailViewModel
constructor(
    private val tripId: Int,
    private val localDBRepository: LocalDBRepository = Graph.localDBRepository
) : ViewModel() {
    var state by mutableStateOf(TripDetailState())
        private set
    val isFieldsValid: Boolean
        get() = state.title.isNotBlank() &&
                state.desc.isNotBlank() &&
                state.startDate.isNotBlank()

    init {
        getTripDetail()
        getAllRoutes()
        getRoutesCount()
    }

    private fun getTripDetail() {
        viewModelScope.launch {
            localDBRepository.getListId(tripId).collectLatest {
                state = state.copy(
                    tripId = it[0].listId,
                    title = it[0].title,
                    desc = it[0].desc,
                    startDate = it[0].startDate
                )
            }
        }
    }

    private fun getAllRoutes() {
        viewModelScope.launch {
            localDBRepository.getAllRoutesFromId(tripId).collectLatest {
                state = state.copy(routes = it)
            }
        }
    }

    private fun getRoutesCount() {
        viewModelScope.launch {
            localDBRepository.getRoutesCount(tripId).let {
                state = state.copy(routeCount = it)
            }
        }
    }

    fun insertRoute(routes: Routes) {
        viewModelScope.launch {
            localDBRepository.insertRoute(routes)
        }
    }

}

@Suppress("UNCHECKED_CAST")
class TripDetailViewModelFactory(
    private val tripId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TripDetailViewModel(tripId) as T
    }
}

data class TripDetailState(
    val tripId: Int = 0,
    val title: String = "",
    val desc: String = "",
    val startDate: String = "",
    val routes: List<Routes> = emptyList(),
    val routeCount: Int = 0
)