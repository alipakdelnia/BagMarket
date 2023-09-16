package com.example.bagmarket.util

sealed class MyScreens (val route : String){

    object MainScreen: MyScreens("MainScreen")
    object ProductScreen: MyScreens("ProductScreen")
    object CategoryScreen: MyScreens("CategoryScreen")
    object ProfileScreen: MyScreens("ProfileScreen")
    object CartScreen: MyScreens("CartScreen")
    object SignUpScreen: MyScreens("SignUpScreen")
    object SignInScreen: MyScreens("SignInScreen")
    object IntroScreen: MyScreens("IntroScreen")
    object NoInternetScreen: MyScreens("NoInternetScreen")

}