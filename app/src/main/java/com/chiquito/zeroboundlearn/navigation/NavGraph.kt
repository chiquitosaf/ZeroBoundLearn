package com.chiquito.zeroboundlearn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chiquito.zeroboundlearn.screens.LoginScreen
import com.chiquito.zeroboundlearn.screens.MainScreen
import com.chiquito.zeroboundlearn.screens.RegisterScreen

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Register.route
    ) {
        composable(route = Screen.Register.route){
            RegisterScreen(navController = navController)
        }
        composable(route = Screen.Login.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Main.route){
            MainScreen()
        }

    }
}