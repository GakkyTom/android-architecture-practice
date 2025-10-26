package com.example.android_architecture_practice.data.local

import com.example.android_architecture_practice.data.model.Photo
import javax.inject.Inject

class FileStorage @Inject constructor() {
    fun save(photo: Photo) {
    }

    fun loadAll(): List<Photo> {
        return emptyList()
    }
}