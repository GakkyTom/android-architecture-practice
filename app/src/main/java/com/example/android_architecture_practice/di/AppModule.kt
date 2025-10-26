package com.example.android_architecture_practice.di

import com.example.android_architecture_practice.data.local.FileStorage
import com.example.android_architecture_practice.data.repository.PhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFileStorage() = FileStorage()

    @Provides
    @Singleton
    fun providePhotoRepository(fileStorage: FileStorage) =
        PhotoRepository(fileStorage)
}