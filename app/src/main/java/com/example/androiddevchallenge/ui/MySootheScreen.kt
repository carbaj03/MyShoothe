package com.example.androiddevchallenge.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.presentation.MainNavigator
import com.example.androiddevchallenge.ui.welcome.WelcomeScreen

sealed class MySootheScreen(val route: String) {
    object Welcome : MySootheScreen("welcome")
    object LogIn : MySootheScreen("logIn")
    object Home : MySootheScreen("home")
}

fun NavGraphBuilder.main(
    navController: NavHostController,
) {
    val main = MainNavigatorComponent(navController = navController)
    composable(MySootheScreen.Welcome.route) {
        WelcomeScreen(main)
    }
}

class MainNavigatorComponent(
    private val navController: NavHostController
) : MainNavigator {
    override fun goBack() {
        navController.popBackStack()
    }

    override fun goWelcome() {
        navController.navigate(MySootheScreen.Welcome.route)
    }

    override fun goLogIn() {
        navController.navigate(MySootheScreen.LogIn.route)
    }

    override fun goHome() {
        navController.navigate(MySootheScreen.Home.route)
    }
}