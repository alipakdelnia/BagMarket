package com.example.bagmarket.ui.features

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bagmarket.ui.features.product.ProductViewModel
import com.example.bagmarket.ui.theme.BackgroundMain
import com.example.bagmarket.ui.theme.MainAppTheme
import dev.burnoo.cokoin.navigation.getNavController
import dev.burnoo.cokoin.navigation.getNavViewModel

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MainAppTheme {
        Surface(color = BackgroundMain, modifier = Modifier.fillMaxSize()) {
            ProductScreen("")
        }
    }
}

@Composable
fun ProductScreen(productId: String) {
    val context = LocalContext.current

    val viewModel = getNavViewModel<ProductViewModel>()
    val navigation = getNavController()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 58.dp)
        ) {

            ProductToolbar(
                productName = "Details",
                badgeNumber = 0,
                OnBackClicked = { navigation.popBackStack() },
                OnCartClicked = {})

        }


    }

}

//---------------------------------------------
@Composable
fun ProductToolbar(
    productName: String,
    badgeNumber: Int,
    OnBackClicked: () -> Unit,
    OnCartClicked: () -> Unit
) {

    TopAppBar(navigationIcon = {
        IconButton(onClick = { OnBackClicked.invoke() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
        }
    },
        elevation = 2.dp,
        backgroundColor = Color.White,
        modifier = Modifier.fillMaxWidth(),
        title = {
            Text(
                text = productName,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 24.dp)
            )
        },
        actions = {
            IconButton(
                modifier = Modifier.padding(end = 10.dp),
                onClick = { OnCartClicked.invoke() }) {
                if (badgeNumber == 0) {
                    Icon(Icons.Default.ShoppingCart, null)
                } else {
                    BadgedBox(badge = { Badge { Text(text = badgeNumber.toString()) } }) {
                        Icon(Icons.Default.ShoppingCart, null)
                    }
                }
            }
        })
}
