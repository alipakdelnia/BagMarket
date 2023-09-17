package com.example.bagmarket.ui.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.bagmarket.R
import com.example.bagmarket.ui.theme.BackgroundMain
import com.example.bagmarket.ui.theme.Blue
import com.example.bagmarket.ui.theme.MainAppTheme
import dev.burnoo.cokoin.navigation.getNavController


@Preview(showBackground = true)
@Composable
fun IntroScreenPreview() {
    MainAppTheme {
        Surface(color = BackgroundMain, modifier = Modifier.fillMaxSize()) {
            IntroScreen()
        }
    }
}

@Composable
fun IntroScreen() {
    val navigation = getNavController()

    Image(
        modifier = Modifier
            .fillMaxSize(),
        painter = painterResource(R.drawable.first_img),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f),//todo: change size
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { }) {

            Text(text = "Sign Up")

        }

        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            onClick = { }) {

            Text(text = "Sign In", color = Blue)

        }

    }
}