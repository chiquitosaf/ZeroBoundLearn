package com.chiquito.zeroboundlearn.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.chiquito.zeroboundlearn.R

@Composable
fun HomeScreen(navController: NavController){
    Column{

    }
}

@Composable
fun HeaderHome(){
    Row{
        Image(
            painter = painterResource(id = R.drawable._d_avatar_23)
            , contentDescription = "profile photo"
        )

        Text(
            text = "hi, Namjoon"

        )
    }

}
