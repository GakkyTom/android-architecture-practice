package com.example.android_architecture_practice.ui.shoot

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.android_architecture_practice.data.model.Photo

@Composable
fun ShootScreen(onPhotoCaptured: (Photo) -> Unit) {
    Text("撮影する")
}