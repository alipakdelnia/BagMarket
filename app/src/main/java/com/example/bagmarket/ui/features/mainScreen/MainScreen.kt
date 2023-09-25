package com.example.bagmarket.ui.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            Text(
                text = "Bags",
                modifier = Modifier.padding(top = 4.dp),
                style = TextStyle(color = Color.Gray)
            )


    }
}

//- - - - - - - - - - - - - - -- - -- - - - -- -- --- --- --  -- ---- --



@Composable
fun ProductSubject() {

    Column(modifier = Modifier.padding(top = 32.dp)) {

        Text(
            text = "Popular Destinations",
            modifier = Modifier.padding(start = 16.dp),
            style = MaterialTheme.typography.h6
        )
        ProductBar()

    }

}

@Composable
fun ProductBar() {

    LazyRow(
        modifier = Modifier.padding(top = 16.dp),
        contentPadding = PaddingValues(end = 16.dp)
    ) {
        items(10) {
           ProductItem()
        }
    }

}
@Composable
fun ProductItem() {

    Card(
        modifier = Modifier
            .padding(start = 16.dp)
            .clickable { },
        elevation = 4.dp,
        shape = Shapes.medium
    ) {
        Column() {
            Image(
                painter = painterResource(id = R.drawable.first_img),
                contentDescription = null,
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop
            )


            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium),
                    text = "Best Laptop Bag"
                )

                Text(
                    text = "560,000 Tomans",
                    style = TextStyle(fontSize = 14.sp),
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(text = "24 sold", style = TextStyle(color = Color.Gray, fontSize = 13.sp))
            }
        }

    }

}


//- - - - - - - - - - - - - - -- - -- - - - -- -- --- --- --  -- ---- --

@Composable
fun BigPictureAds() {

    Image(
        painter = painterResource(id = R.drawable.first_img),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp)
            .clip(Shapes.medium)
            .clickable { },
        contentScale = ContentScale.Crop
    )

}
