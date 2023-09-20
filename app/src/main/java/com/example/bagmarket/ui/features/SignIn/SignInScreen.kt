package com.example.bagmarket.ui.features.SignIn


import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.bagmarket.R
import com.example.bagmarket.ui.features.signUp.SignUpViewModel
import com.example.bagmarket.ui.theme.BackgroundMain
import com.example.bagmarket.ui.theme.Blue
import com.example.bagmarket.ui.theme.MainAppTheme
import com.example.bagmarket.ui.theme.Shapes
import com.example.bagmarket.util.MyScreens
import com.example.bagmarket.util.NetworkChecker
import com.example.bagmarket.util.VALUE_SUCCESS
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.burnoo.cokoin.navigation.getNavController
import dev.burnoo.cokoin.navigation.getNavViewModel

@Preview(showBackground = true)
@Composable
fun SingInScreenPreview() {
    MainAppTheme {
        Surface(color = BackgroundMain, modifier = Modifier.fillMaxSize()) {
            SingInScreen()
        }
    }
}

@Composable
fun SingInScreen() {
    val uiController = rememberSystemUiController()
    SideEffect { uiController.setStatusBarColor(Blue) }

    val context = LocalContext.current

    val navigation = getNavController()
    val viewModel = getNavViewModel<SignInViewModel>()

    Box {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .background(color = Blue)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            IconApp()

            MainCardView(navigation, viewModel) {
                viewModel.signInUser {
                    if (it == VALUE_SUCCESS) {
                        navigation.navigate(MyScreens.MainScreen.route) {
                            popUpTo(MyScreens.IntroScreen.route) {
                                inclusive = true
                            }
                        }

                    } else {
                        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                    }
                }
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

        Image(
            painter = painterResource(id = R.drawable.bag_market_icon),
            contentDescription = null
        )

    }
}


@Composable
fun MainCardView(navigation: NavController, viewModel: SignInViewModel, SignInEvent: () -> Unit) {
    val email = viewModel.email.observeAsState("")
    val password = viewModel.password.observeAsState("")
    val context = LocalContext.current

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
                text = "${stringResource(R.string.sign_in)}!",
                modifier = Modifier.padding(top = 18.dp, bottom = 18.dp),
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            )


            MainTextField(
                edtValue = email.value,
                icon = R.drawable.baseline_email_24,
                hint = stringResource(R.string.email)
            ) { viewModel.email.value = it }
            PasswordTextField(
                edtValue = password.value,
                icon = R.drawable.baseline_lock_24,
                hint = stringResource(R.string.password)
            ) { viewModel.password.value = it }


            Button(
                onClick = {

                    if (email.value.isNotEmpty() &&
                        password.value.isNotEmpty()
                    ) {
                        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
                            if (NetworkChecker(context).isInternetConnected) {
                                SignInEvent.invoke()
                                Toast.makeText(
                                    context,
                                    R.string.loged_in,
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(
                                    context,
                                    R.string.check_internet_connection,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                R.string.enter_true_email_address,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            context,
                            R.string.please_enter_all_values,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                },
                modifier = Modifier.padding(top = 28.dp, bottom = 8.dp)
            ) {
                Text(modifier = Modifier.padding(8.dp), text = stringResource(R.string.log_in))
            }

            Row(
                modifier = Modifier.padding(18.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(R.string.Do_not_have_an_account))
                TextButton(onClick = {
                    navigation.navigate(MyScreens.SignUpScreen.route) {
                        popUpTo(MyScreens.SignInScreen.route) {
                            inclusive = true
                        }
                    }
                }) {
                    Text(text = stringResource(R.string.RegisterHere), color = Color.Blue)
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
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image =
                if (passwordVisibility.value) painterResource(R.drawable.baseline_visibility_off_24)
                else painterResource(R.drawable.baseline_visibility_24)

            Icon(
                painter = image,
                contentDescription = null,
                modifier = Modifier.clickable {
                    passwordVisibility.value = !passwordVisibility.value
                }
            )
        }

    )

}
