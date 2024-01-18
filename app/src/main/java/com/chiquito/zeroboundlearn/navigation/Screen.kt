package com.chiquito.zeroboundlearn.navigation

sealed class Screen(val route: String) {
    data object Register: Screen("register")
    data object Login: Screen("login")
    data object Home: Screen("home")
    data object OrderList: Screen("orderList")
    data object Chat: Screen("chat")
    data object Main: Screen("main")

}