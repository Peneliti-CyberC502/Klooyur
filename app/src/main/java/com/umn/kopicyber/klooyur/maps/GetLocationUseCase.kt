package com.umn.kopicyber.klooyur.maps

import android.location.Location
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(
    private val locationRepository: LocationRepository
) {
    operator fun invoke(location: (Location) -> Unit) = locationRepository.getLocationOnce(location)
}
