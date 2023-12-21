package com.umn.kopicyber.klooyur.maps

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {
    @Provides
    fun provideSearchPlacesUseCase(
        locationRepository: LocationRepository
    ): SearchPlacesUseCase {
        return SearchPlacesUseCase(locationRepository)
    }
}