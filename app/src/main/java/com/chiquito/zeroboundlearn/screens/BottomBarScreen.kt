package com.chiquito.zeroboundlearn.screens

import androidx.annotation.DrawableRes
import com.chiquito.zeroboundlearn.R
import com.chiquito.zeroboundlearn.navigation.Screen

sealed class BottomBarScreen(
    val route: String,
    @DrawableRes val icon: Int
){
    data object Home : BottomBarScreen(
        route = Screen.Home.route,
        icon = R.drawable.ic_home_navbar
    )
    data object OrderList : BottomBarScreen(
        route = Screen.OrderList.route,
        icon = R.drawable.ic_orderlist_navbar
    )
    data object Chat : BottomBarScreen(
            route = Screen.Chat.route,
            icon = R.drawable.ic_chat_navbar
        )

}