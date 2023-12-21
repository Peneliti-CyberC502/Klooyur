package com.umn.kopicyber.klooyur.maps

import android.location.Location
import com.google.android.libraries.places.api.model.AutocompletePrediction
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun getLocationOnce(location: (Location) -> Unit)
    fun searchPlaces(
        query: String,
    ): Flow<PlacesResult>
}

sealed class PlacesResult(
    val location: Location? = null,
    val list: MutableList<AutocompletePrediction> = mutableListOf(),
    val message: String? = null
) {
    class Success(location: Location, list: MutableList<AutocompletePrediction>) :
        PlacesResult(location, list)

    class Loading() : PlacesResult()
    class Error(message: String) : PlacesResult(message = message)
    class Idle() : PlacesResult()
}