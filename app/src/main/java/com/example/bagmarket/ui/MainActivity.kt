package com.example.bagmarket.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bagmarket.di.myModules
import com.example.bagmarket.ui.features.*
import com.example.bagmarket.ui.features.SignIn.SingInScreen
import com.example.bagmarket.ui.features.signUp.SingUpScreen
import com.example.bagmarket.ui.theme.BackgroundMain
import com.example.bagmarket.ui.theme.MainAppTheme
import com.example.bagmarket.util.KEY_CATEGORY_ARG
import com.example.bagmarket.util.KEY_PRODUCT_ARG
import com.example.bagmarket.util.MyScreens
import dev.burnoo.cokoin.Koin
import dev.burnoo.cokoin.navigation.KoinNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Koin(appDeclaration = { modules(myModules) }) {
                MainAppTheme {
                    Surface(color = BackgroundMain, modifier = Modifier.fillMaxSize()) {
                        BagMarketUi()
                    }
                }
            }

        }
    }

}

@Composable
fun BagMarketUi() {

    val navController = rememberNavController()
    KoinNavHost(
        navController = navController,
        startDestination = MyScreens.IntroScreen.route
    ) {

        composable(MyScreens.MainScreen.route) {
            MainScreen()
        }

        composable(
            route = MyScreens.ProductScreen.route +"/"+ KEY_PRODUCT_ARG,
            arguments = listOf(navArgument(KEY_PRODUCT_ARG) {
                type = NavType.IntType
            })
        ) {
            ProductScreen(it.arguments!!.getInt(KEY_PRODUCT_ARG, -1))
        }

        composable(
            route = MyScreens.CategoryScreen.route+"/"+ KEY_CATEGORY_ARG,
            arguments = listOf(navArgument(KEY_CATEGORY_ARG) {
                type = NavType.StringType
            })
        ) {
            CategoryScreen(it.arguments!!.getString(KEY_CATEGORY_ARG, "null"))
        }

        composable(MyScreens.ProfileScreen.route) {
            ProfileScreen()
        }

        composable(MyScreens.CartScreen.route) {
            CartScreen()
        }

        composable(MyScreens.SignUpScreen.route) {
            SingUpScreen()
        }

        composable(MyScreens.SignInScreen.route) {
            SingInScreen()
        }

        composable(MyScreens.IntroScreen.route) {
            IntroScreen()
        }

        composable(MyScreens.NoInternetScreen.route) {
            NoInternetScreen()
        }


    }


}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MainAppTheme { BagMarketUi() }
}