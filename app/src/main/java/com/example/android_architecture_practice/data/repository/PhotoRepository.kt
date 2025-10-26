package com.example.android_architecture_practice.data.repository

import com.example.android_architecture_practice.data.local.FileStorage
import com.example.android_architecture_practice.data.model.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val fileStorage: FileStorage
) {
    suspend fun savePhoto(photo: Photo) = withContext(Dispatchers.IO) {
        fileStorage.save(photo)
    }

    suspend fun getPhotos(): List<Photo> = withContext(Dispatchers.IO) {
        fileStorage.loadAll()
    }
}
