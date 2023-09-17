package com.example.bagmarket.ui.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    Box {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .background(color = Color.Blue)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            IconApp()

            MainCardView {

            }

        }

    }


}

@Composable
fun IconApp() {
    Surface(
        modifier = Modifier
            .clip(CircleShape)
            .size(40.dp)
    ) {

        Image(painter = painterResource(id = R.drawable.bag_market_icon), contentDescription = null)

    }
}


@Composable
fun MainCardView(SignUpEvent: () -> Unit) {
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmedPassword = remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        elevation = 10.dp,
        shape = Shapes.medium
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Sign Up!",
                modifier = Modifier.padding(top = 18.dp, bottom = 18.dp),
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            MainTextField(
                edtValue = name.value,
                icon = R.drawable.baseline_person_24,
                hint = "your full name..."
            ) { name.value = it }
            MainTextField(
                edtValue = email.value,
                icon = R.drawable.baseline_email_24,
                hint = "email..."
            ) { email.value = it }
            MainTextField(
                edtValue = password.value,
                icon = R.drawable.baseline_lock_24,
                hint = "password..."
            ) { password.value = it }
            MainTextField(
                edtValue = confirmedPassword.value,
                icon = R.drawable.baseline_lock_24,
                hint = "confirm password..."
            ) { confirmedPassword.value = it }

            Button(
                onClick = SignUpEvent,
                modifier = Modifier.padding(top = 28.dp, bottom = 8.dp)
            ) {
                Text(modifier = Modifier.padding(8.dp), text = "Register Account")
            }

            Row(
                modifier = Modifier.padding(18.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Already have an account ? ")
                TextButton(onClick = { }) {
                    Text(text = " Log In ", color = Color.Blue)
                }
            }


        }

    }

}

@Composable
fun MainTextField(
    edtValue: String,
    icon: Int,
    hint: String,
    onValueChanges: (String) -> Unit
) {

    OutlinedTextField(
        label = { Text(hint) },
        value = edtValue,
        singleLine = true,
        onValueChange = onValueChanges,
        placeholder = { Text(hint) },
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 12.dp),
        shape = Shapes.medium,
        leadingIcon = { Icon(painterResource(icon), null) }

    )

}
