package com.example.bagmarket.ui.features.SignIn

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bagmarket.model.repository.UserRepository
import kotlinx.coroutines.launch

class SignInViewModel(private val userRepository: UserRepository) : ViewModel(){
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun signInUser (LoggingEvent:(String)->Unit){

viewModelScope.launch {
    val result = userRepository.signIn(email.value!!,password.value!!)
    LoggingEvent(result)
}

    }

}