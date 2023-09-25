package com.example.bagmarket.model.repository.user

import android.content.SharedPreferences
import com.example.bagmarket.model.net.ApiService
import com.example.bagmarket.model.repository.TokenInMemory
import com.example.bagmarket.util.VALUE_SUCCESS
import com.google.gson.JsonObject

//User Repository Implementations:
class UserRepositoryImpl(
    private val apiService : ApiService,
    private val sharedPref : SharedPreferences
): UserRepository {

    override suspend fun signUp(name: String, userName: String, password: String):String {

        val jsonObject = JsonObject().apply{
            addProperty("name",name)
            addProperty("email",userName)
            addProperty("password",password)
        }

        val result = apiService.signUp(jsonObject)
        if (result.success){
            TokenInMemory.refreshToken(userName, result.token)
            saveToken(result.token)
            saveUserName(userName)
            return VALUE_SUCCESS
        }else{
            return result.message
        }

    }
    override suspend fun signIn(userName: String, password: String):String {

        val jasonObject = JsonObject().apply {
            addProperty("email",userName)
            addProperty("password",password)
        }

        val result = apiService.singIn(jasonObject)
        if (result.success){
            TokenInMemory.refreshToken(userName, result.token)
            saveToken(result.token)
            saveUserName(userName)
            return VALUE_SUCCESS
        }else{
            return result.message
        }

    }

    override fun signOut() {
        TokenInMemory.refreshToken(null, null)
        sharedPref.edit().clear().apply()
    }

    override fun loadToken() {
        TokenInMemory.refreshToken(getUserName(), getToken())
    }

    override fun saveToken(newToken: String) {
        sharedPref.edit().putString("token",newToken).apply()
    }

    override fun getToken(): String? {
        return sharedPref.getString("token",null)
    }

    override fun saveUserName(userName: String) {
        sharedPref.edit().putString("username",userName).apply()
    }

    override fun getUserName(): String? {
        return sharedPref.getString("username",null)
    }


}