package com.thernat.ageofapocalypse.di

import com.thernat.ageofapocalypse.api.MarvelService
import com.thernat.ageofapocalypse.repository.ComicsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideComicsRemoteSource(marvelService: MarvelService) = ComicsRepository(marvelService)
}