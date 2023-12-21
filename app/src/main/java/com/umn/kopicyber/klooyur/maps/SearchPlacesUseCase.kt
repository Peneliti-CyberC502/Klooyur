package com.umn.kopicyber.klooyur.maps

import javax.inject.Inject

class SearchPlacesUseCase @Inject constructor(
    private val locationRepository: LocationRepository
) {
    operator fun invoke(query: String) = locationRepository.searchPlaces(query)
}