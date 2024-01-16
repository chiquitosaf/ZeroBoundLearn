package com.chiquito.zeroboundlearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chiquito.zeroboundlearn.ui.theme.AppFont
import com.chiquito.zeroboundlearn.ui.theme.Dark_Blue
import com.chiquito.zeroboundlearn.ui.theme.Grey
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
                    Register()
                }
            }
        }
    }
}

@Composable
fun Register() {
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

        Button(
            onClick = { /*TODO*/ },
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
            )
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(105.dp))
    }

}

@Composable
fun InputTextField(label: String, modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxWidth()
    ){
        Text(
            text = label,
            style = TextStyle(
                color = Dark_Blue,
                fontFamily = AppFont.Outfit,
                fontWeight = FontWeight.W400,
                textAlign = TextAlign.Start,
                fontSize = 15.sp
            )
        )

        val inputText = rememberSaveable { mutableStateOf("") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }

        val keyboardOpt =
            when (label) {
                "Password" -> KeyboardOptions(keyboardType = KeyboardType.Password)
                "Email" -> KeyboardOptions(keyboardType = KeyboardType.Email)
                else -> KeyboardOptions(keyboardType = KeyboardType.Text)
            }
        val icon: @Composable() (()->Unit)? = {
            if (label == "Password"){
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(imageVector  = image, description)
                }
            }
        }

        val visual = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()

        OutlinedTextField(
            value = inputText.value,
            onValueChange = { inputText.value = it },
            singleLine = true,
            shape = RoundedCornerShape(50.dp),
            visualTransformation = visual,
            placeholder = {
                Text(
                    text = "Your $label...",
                    style = TextStyle(
                        color = Grey,
                        fontFamily = AppFont.Outfit,
                        fontWeight = FontWeight.W400,
                        fontSize = 15.sp
                    ),
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Dark_Blue,
                unfocusedIndicatorColor = Dark_Blue

            ),
            keyboardOptions = keyboardOpt,
            trailingIcon = icon ,
            modifier = Modifier
                .fillMaxWidth()
        )
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
        Register()
    }
}
