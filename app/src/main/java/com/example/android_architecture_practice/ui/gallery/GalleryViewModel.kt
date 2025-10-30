package com.example.android_architecture_practice.ui.gallery

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(GalleryUiState())
    val uiState = _uiState.asStateFlow()

    fun loadImages(context: Context) {
        // Implementation to load images and update _uiState
        viewModelScope.launch {
            val cacheDir = context.cacheDir
            val images = cacheDir.listFiles()?.toList() ?: emptyList()

            _uiState.value = GalleryUiState(imageFiles = images)
        }


    }
}