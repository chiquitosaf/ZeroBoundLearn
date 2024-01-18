package com.chiquito.zeroboundlearn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chiquito.zeroboundlearn.screens.ChatScreen
import com.chiquito.zeroboundlearn.screens.HomeScreen
import com.chiquito.zeroboundlearn.screens.OrderListScreen

@Composable
fun MainNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(route = Screen.OrderList.route){
            OrderListScreen(navController = navController)
        }
        composable(route = Screen.Chat.route) {
            ChatScreen(navController = navController)
        }
    }
}