package com.example.bagmarket.ui.features

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import com.example.bagmarket.R
import com.example.bagmarket.ui.theme.BackgroundMain
import com.example.bagmarket.ui.theme.Blue
import com.example.bagmarket.ui.theme.MainAppTheme
import com.example.bagmarket.util.MyScreens
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
    val uriHandler = LocalUriHandler.current



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
            .fillMaxHeight(0.75f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(text = stringResource(R.string.choose_language)
            , style = TextStyle(color = Color.White,fontSize = 23.sp)
        , modifier = Modifier.padding(top = 16.dp))

        Row() {
            Image(
                painter = painterResource(R.drawable.iran_flag),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 1.dp, start = 16.dp, end = 60.dp)
                    .size(77.dp, 77.dp)
                    .clickable {
                    }
            )
            Image(
                painter = painterResource(R.drawable.us_flag),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp, start = 60.dp, end = 8.dp)
                    .size(60.dp, 60.dp)
                    .clickable {}
            )

        }

    }



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.62f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = {
                navigation.navigate(MyScreens.SignUpScreen.route)
            }) {

            Text(text = stringResource(R.string.sign_up))

        }

        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            onClick = {
                navigation.navigate(MyScreens.SignInScreen.route)
            }) { Text(text = stringResource(R.string.sign_in), color = Blue) }


    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.95f),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "Created by",
            modifier = Modifier
                .rotate(23f)
                .padding(end = 45.dp, bottom = 15.dp)
        )
        Text(
            text = "Ali Pakdelnia",
            modifier = Modifier
                .rotate(23f)
                .padding(end = 15.dp, bottom = 15.dp)
        )
        Image(
            painter = painterResource(R.drawable.github_logo),
            contentDescription = null,
            modifier = Modifier
                .rotate(23f)
                .padding(end = 60.dp)
                .size(85.dp, 85.dp)
                .clickable {
                    uriHandler.openUri("https://github.com/alipakdelnia")
                }

        )
    }


}