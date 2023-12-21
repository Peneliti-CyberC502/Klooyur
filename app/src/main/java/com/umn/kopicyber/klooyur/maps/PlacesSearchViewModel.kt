package com.umn.kopicyber.klooyur.maps

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class PlacesSearchViewModel @Inject
constructor(
    private val searchPlacesUseCase: SearchPlacesUseCase,
    private val getLocationUseCase: GetLocationUseCase
): ViewModel() {

    private val _search: MutableState<PlacesResult> = mutableStateOf<PlacesResult>(PlacesResult.Idle())
    val search: State<PlacesResult> get() = _search

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query

    private val _currentLocation: MutableState<LatLng> = mutableStateOf(LatLng(0.0, 0.0))
    val currentLocation: State<LatLng> get() = _currentLocation

    fun updateQuery(query: String) {
        _query.value = query
    }

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                searchPlaces(it)
            }
            getCurrentLocation()
        }
    }
    fun searchPlaces(query: String) = viewModelScope.launch {
        searchPlacesUseCase(query).collectLatest {
            _search.value = it
        }
    }
    fun getCurrentLocation() = viewModelScope.launch {
        getLocationUseCase { location ->
            _currentLocation.value = LatLng(location.latitude, location.longitude)
        }
    }
}
