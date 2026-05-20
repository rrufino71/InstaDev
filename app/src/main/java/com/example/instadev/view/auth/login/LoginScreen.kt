package com.example.instadev.view.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instadev.R


@Preview
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold { padding ->
        Column(
            Modifier
                .background(Color.White)
                .padding(padding) //padding top
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Español (España)", color = Color.Gray, modifier = Modifier.padding(top = 22.dp))
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(65.dp),
                painter = painterResource(R.drawable.logo_instagram),
                contentDescription = "Logo InstaDev"
            )
            Spacer(Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = email,
                onValueChange = { email = it })
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = password,
                onValueChange = { password = it })
            Spacer(Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                onClick = {}) {
                Text(
                    modifier = Modifier
                        .padding(
                            vertical = 4.dp
                        ), text = "Iniciar sesión"
                )
            }
            TextButton(onClick = {}) { Text("Has olvidado tu contraseña ?") }
            Spacer(Modifier.weight(1.3f))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}) { Text("Crear cuenta nueva") }
            Icon(
                modifier = Modifier
                    .width(30.dp)
                    .padding(vertical = 24.dp),
                painter = painterResource(R.drawable.logo_meta),
                contentDescription = "Logo Meta",
                tint = Color.Gray,

                )
        }
    }
}