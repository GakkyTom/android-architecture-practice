package com.example.android_architecture_practice.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_architecture_practice.ui.theme.AndroidarchitecturepracticeTheme

@Composable
fun HomeScreen(
    onNavigateToShoot: () -> Unit,
    onNavigateToGallery: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "App Home",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onNavigateToShoot, modifier = Modifier.fillMaxWidth(0.8f)) {
            Text("Shoot photo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNavigateToGallery, modifier = Modifier.fillMaxWidth(0.8f)) {
            Text("Gallery")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AndroidarchitecturepracticeTheme {
        HomeScreen(
            onNavigateToShoot = {},
        ) {}
    }
}