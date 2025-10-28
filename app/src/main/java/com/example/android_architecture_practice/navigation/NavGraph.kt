package com.example.android_architecture_practice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.android_architecture_practice.ui.edit.EditScreen
import com.example.android_architecture_practice.ui.gallery.GalleryScreen
import com.example.android_architecture_practice.ui.home.HomeScreen
import com.example.android_architecture_practice.ui.shoot.ShootScreen
import com.example.android_architecture_practice.viewmodel.SharedAppViewModel

@Composable
fun AppNavGraph(navController: NavHostController, sharedAppViewModel: SharedAppViewModel) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onNavigateToShoot = { navController.navigate("shoot") },
                onNavigateToGallery = { navController.navigate("gallery") }
            )
        }

        composable("shoot") {
            ShootScreen(
                onPhotoCaptured = { photo ->
                    sharedAppViewModel.savePhoto(photo)
                    navController.navigate("edit")
                }
            )
        }

        composable("gallery") {
            GalleryScreen(
                onNavigateToEdit = {
                    navController.navigate("edit")
                }
            )
        }

        composable("edit") {
            EditScreen()
        }
    }
}