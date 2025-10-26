package com.example.android_architecture_practice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.android_architecture_practice.ui.shoot.ShootScreen
import com.example.android_architecture_practice.viewmodel.SharedAppViewModel

@Composable
fun AppNavGraph(navController: NavHostController, sharedAppViewModel: SharedAppViewModel) {
    NavHost(navController, startDestination = "shoot") {
        composable("shoot") {
            ShootScreen(
                onPhotoCaptured = { photo ->
                    sharedAppViewModel.savePhoto(photo)
                    // TODO: 編集画面作成
                    navController.navigate("edit")
                }
            )
        }

        // TODO: 編集画面
        // TODO: 一覧画面
    }
}