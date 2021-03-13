package com.example.androiddevchallenge.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.presentation.MainNavigator

@Composable
fun WelcomeScreen(
    mainNavigator: MainNavigator,
    theme: Boolean = isSystemInDarkTheme()
) {
    val background = if (theme) R.drawable.ic_dark_welcome else R.drawable.ic_light_welcome
    val logo = if (theme) R.drawable.ic_dark_logo else R.drawable.ic_light_logo

    Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = background),
        contentDescription = "Background"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = logo), contentDescription = null)

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
            shape = MaterialTheme.shapes.medium,
            onClick = { }
        ) {
            Text(
                text = "SIGN UP",
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
            shape = MaterialTheme.shapes.medium,
            onClick = { mainNavigator.goLogIn() }
        ) {
            Text(
                text = "LOG IN",
            )
        }
    }

}