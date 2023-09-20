package com.example.bagmarket.ui.features.signUp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bagmarket.model.repository.UserRepository

class SignUpViewModel(private val userRepository: UserRepository) : ViewModel(){
    val name = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val confirmPassword = MutableLiveData("")

    fun signUpUser (){

        Log.v ("testLog",name.value!!)

    }

}