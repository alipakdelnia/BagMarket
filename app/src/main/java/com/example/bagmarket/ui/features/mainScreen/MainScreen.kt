package com.example.bagmarket.ui.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bagmarket.ui.theme.BackgroundMain
import com.example.bagmarket.ui.theme.CardViewBackground
import com.example.bagmarket.ui.theme.MainAppTheme
import com.example.bagmarket.ui.theme.Shapes
import com.example.bagmarket.R

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MainAppTheme {
        Surface(color = BackgroundMain, modifier = Modifier.fillMaxSize()) {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 16.dp)
    ) {
        TopToolBar()

        CategoryBar()

        ProductSubject()
        ProductSubject()

        BigPictureAds()

        ProductSubject()
        ProductSubject()
    }


}



//- - - - - - - - - - - - - - -- - -- - - - -- -- --- --- --  -- ---- --

@Composable
fun TopToolBar() {

    TopAppBar(
        elevation = 0.dp,
        backgroundColor = Color.White,
        title = { Text(text = "Bag Market") },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.ShoppingCart, contentDescription = null)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.Person, contentDescription = null)
            }

        }

    )

}

//- - - - - - - - - - - - - - -- - -- - - - -- -- --- --- --  -- ---- --

@Composable
fun CategoryBar() {

    LazyRow(
        modifier = Modifier.padding(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(10) {
            CategoryItem()
        }
    }


}

@Composable
fun CategoryItem() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clickable { },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(shape = Shapes.medium, color = CardViewBackground) {
            Image(painter = painterResource(id = R.drawable.iran_flag), contentDescription = null)
        }
    }
}

//- - - - - - - - - - - - - - -- - -- - - - -- -- --- --- --  -- ---- --

@Composable
fun ProductSubject() {


}

//- - - - - - - - - - - - - - -- - -- - - - -- -- --- --- --  -- ---- --

@Composable
fun BigPictureAds() {


}
