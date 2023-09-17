package com.example.bagmarket.ui.features.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bagmarket.R
import com.example.bagmarket.ui.features.signUp.SignUpViewModel
import com.example.bagmarket.ui.theme.BackgroundMain
import com.example.bagmarket.ui.theme.MainAppTheme
import com.example.bagmarket.ui.theme.Shapes
import dev.burnoo.cokoin.navigation.getNavController
import dev.burnoo.cokoin.navigation.getNavViewModel

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

    val navigation = getNavController()
    val viewModel =  getNavViewModel<SignUpViewModel>( )

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

            MainCardView(viewModel) {
                viewModel.signUpUser()
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
fun MainCardView(viewModel: SignUpViewModel,SignUpEvent: () -> Unit) {
    val name = viewModel.name.observeAsState("")
    val email = viewModel.email.observeAsState("")
    val password =viewModel.password.observeAsState("")
    val confirmedPassword = viewModel.confirmPassword.observeAsState("")

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
            ) { viewModel.name.value = it }
            MainTextField(
                edtValue = email.value,
                icon = R.drawable.baseline_email_24,
                hint = "email..."
            ) { viewModel.email.value = it }
            PasswordTextField(
                edtValue = password.value,
                icon = R.drawable.baseline_lock_24,
                hint = "password..."
            ) { viewModel.password.value = it }
            PasswordTextField(
                edtValue = confirmedPassword.value,
                icon = R.drawable.baseline_lock_24,
                hint = "confirm password..."
            ) { viewModel.confirmPassword.value = it }

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
@Composable
fun PasswordTextField(
    edtValue: String,
    icon: Int,
    hint: String,
    onValueChanges: (String) -> Unit
) {
    val passwordVisibility = remember { mutableStateOf(false) }

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
        leadingIcon = { Icon(painterResource(icon), null) },
        visualTransformation = if(passwordVisibility.value ) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if( passwordVisibility.value ) painterResource(R.drawable.baseline_visibility_off_24)
            else painterResource(R.drawable.baseline_visibility_24)

            Icon(
                painter = image,
                contentDescription = null ,
                modifier = Modifier.clickable { passwordVisibility.value = !passwordVisibility.value }
            )
        }

    )

}
