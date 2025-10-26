package com.example.android_architecture_practice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_architecture_practice.data.model.Photo
import com.example.android_architecture_practice.data.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedAppViewModel @Inject constructor(
    private val repository: PhotoRepository
) : ViewModel() {

    private val _photos = MutableStateFlow<List<Photo>>(emptyList())
    val photo: StateFlow<List<Photo>> = _photos.asStateFlow()

    private val _selectedPhoto = MutableStateFlow<Photo?>(null)
    val selectedPhoto: StateFlow<Photo?> = _selectedPhoto.asStateFlow()

    fun loadGallery() {
        viewModelScope.launch {
            _photos.value = repository.getPhotos()
        }
    }

    fun selectPhoto(photo: Photo) {
        _selectedPhoto.value = photo
    }

    fun savePhoto(photo: Photo) {
        viewModelScope.launch {
            repository.savePhoto(photo)
            loadGallery()
        }
    }
}
