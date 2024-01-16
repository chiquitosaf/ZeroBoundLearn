package com.chiquito.zeroboundlearn.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chiquito.zeroboundlearn.R
import com.chiquito.zeroboundlearn.commons.InputTextField
import com.chiquito.zeroboundlearn.navigation.Screen
import com.chiquito.zeroboundlearn.ui.theme.AppFont
import com.chiquito.zeroboundlearn.ui.theme.Dark_Blue
import com.chiquito.zeroboundlearn.ui.theme.ZeroBoundLearnTheme

@Composable
fun RegisterScreen(navController: NavHostController) {
    //content
    Column(
        modifier = Modifier
            .padding(start = 31.dp, end = 31.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.padding(top = 50.dp)
        )
        Text(
            text = "Create Account",
            style = TextStyle(
                color = Dark_Blue,
                fontFamily = AppFont.Outfit,
                fontWeight = FontWeight.W600,
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            ),
            modifier = Modifier
                .padding(top = 40.dp)
        )

        InputTextField("Email", modifier = Modifier.padding(top = 38.dp))
        InputTextField("Username", modifier = Modifier.padding(top = 26.dp))
        InputTextField("Password", modifier = Modifier.padding(top = 26.dp))

        //Sign up button
        Button(
            onClick = {
                      navController.navigate(Screen.Login.route)
            },
            modifier = Modifier
                .padding(top = 38.dp)
                .height(43.dp)
                .width(138.dp)
        ) {
            Text(
                text = "Sign up",
                style = TextStyle(
                    color = Color.White,
                    fontFamily = AppFont.Outfit,
                    fontWeight = FontWeight.W600,
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                ),
            )
        }

        Row (
            modifier = Modifier.padding(top = 38.dp)
        ){
            Text(
                text = "Already have an account? ",
                style = TextStyle(
                    color = Dark_Blue,
                    fontFamily = AppFont.Outfit,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                ),
            )
            Text(
                text = "sign in",
                style = TextStyle(
                    color = Dark_Blue,
                    fontFamily = AppFont.Outfit,
                    fontWeight = FontWeight.W600,
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                ),
                modifier = Modifier.clickable { navController.navigate(Screen.Login.route) }
            )
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(105.dp))
    }

}

@Preview
@Composable
fun PreviewTextField(){
    InputTextField("test")
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview(){
    ZeroBoundLearnTheme {
        RegisterScreen(rememberNavController())
    }
}