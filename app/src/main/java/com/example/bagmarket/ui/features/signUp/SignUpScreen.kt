package com.example.bagmarket.ui.features

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bagmarket.R
import com.example.bagmarket.ui.theme.BackgroundMain
import com.example.bagmarket.ui.theme.MainAppTheme
import com.example.bagmarket.ui.theme.Shapes

@Preview(showBackground = true)
@Composable
 fun SingUpScreenPreview() {
    MainAppTheme {
        Surface(color = BackgroundMain, modifier = Modifier.fillMaxSize()) {
            SingUpScreen()
        }
    }

}

@Composable
fun SingUpScreen() {

    MainTextField(edtValue = "hello", icon = R.drawable.bag_market_icon, hint = "text input"  ){

    }

}

@Composable
fun MainTextField (
    edtValue:String,
    icon:Int,
    hint:String,
    onValueChanges:(String) -> Unit
){

    OutlinedTextField(
        label = { Text(hint)},
        value = edtValue,
        singleLine = true,
        onValueChange = onValueChanges,
        placeholder = { Text(hint)},
        modifier = Modifier
            .fillMaxSize(0.9f)
            .padding(top = 12.dp),
        shape = Shapes.medium,
        leadingIcon = { Icon(painterResource(icon),  null )}

    )

}
