package com.example.android_architecture_practice.ui.edit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.android_architecture_practice.viewmodel.SharedAppViewModel

@Composable
fun EditScreen(
    sharedAppViewModel: SharedAppViewModel,
    iconName: String
) {
    val bitmap by sharedAppViewModel.capturedImage.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        bitmap?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "Captured image",
                modifier = Modifier
                    .size(300.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
        } ?: Text("撮影画像がありません")

        Spacer(Modifier.height(32.dp))
    }
}
