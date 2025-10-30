package com.example.android_architecture_practice.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.android_architecture_practice.ui.edit.EditScreen
import com.example.android_architecture_practice.ui.gallery.GalleryScreen
import com.example.android_architecture_practice.ui.gallery.GalleryViewModel
import com.example.android_architecture_practice.ui.home.HomeScreen
import com.example.android_architecture_practice.ui.shoot.ShootScreen
import com.example.android_architecture_practice.ui.shoot.ShootViewModel
import com.example.android_architecture_practice.viewmodel.SharedAppViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    sharedAppViewModel: SharedAppViewModel,
    shootViewModel: ShootViewModel,
    galleryViewModel: GalleryViewModel
) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onNavigateToShoot = { navController.navigate("shoot") },
                onNavigateToGallery = { navController.navigate("gallery") }
            )
        }

        composable("shoot") {
            ShootScreen(shootViewModel = shootViewModel)
        }

        composable("gallery") {
            GalleryScreen(
                viewModel = galleryViewModel,
                onImageClick = { filePath ->
                    navController.navigate(
                        // ファイルパスにスラッシュなどの特殊文字が含まれる可能性があるためエンコードする
                        "edit/${Uri.encode(filePath)}"
                    )
                }
            )
        }

        composable(
            "edit/{filePath}",
            arguments = listOf(navArgument("filePath") { defaultValue = "" })
        ) { backStackEntry ->
            val encodedFilePath = backStackEntry.arguments?.getString("filePath") ?: ""
            val decodedFilePath = Uri.decode(encodedFilePath)
            EditScreen(
                sharedAppViewModel,
                decodedFilePath
            )
        }
    }
}