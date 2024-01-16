package com.chiquito.zeroboundlearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chiquito.zeroboundlearn.navigation.Screen
import com.chiquito.zeroboundlearn.screens.LoginScreen
import com.chiquito.zeroboundlearn.screens.RegisterScreen
import com.chiquito.zeroboundlearn.ui.theme.ZeroBoundLearnTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZeroBoundLearnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   val navController = rememberNavController()

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
                    }
                }
            }
        }
    }
}

