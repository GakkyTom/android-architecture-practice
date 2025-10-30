package com.example.android_architecture_practice.ui.gallery

import java.io.File

data class GalleryUiState(
    val imageFiles: List<File> = emptyList()
)