package com.example.bagmarket.ui.features.SignIn

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel(){
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun signInUser (){

        Log.v ("testLog",email.value!!)

    }

}