package com.chiquito.zeroboundlearn.commons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chiquito.zeroboundlearn.ui.theme.AppFont
import com.chiquito.zeroboundlearn.ui.theme.Dark_Blue
import com.chiquito.zeroboundlearn.ui.theme.Grey

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
