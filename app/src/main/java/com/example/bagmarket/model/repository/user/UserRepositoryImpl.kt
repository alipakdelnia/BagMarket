package com.example.bagmarket.model.repository.user

import android.content.SharedPreferences
import com.example.bagmarket.model.net.ApiService
import com.example.bagmarket.model.repository.TokenInMemory
import com.example.bagmarket.util.VALUE_SUCCESS
import com.google.gson.JsonObject

//User Repository Implementations:
class UserRepositoryImpl(
    private val apiService: ApiService,
    private val sharedPref: SharedPreferences
) : UserRepository {

    override suspend fun signUp(name: String, userName: String, password: String): String {

        val jsonObject = JsonObject().apply {
            addProperty("name", name)
            addProperty("email", userName)
            addProperty("password", password)
        }

        val result = apiService.signUp(jsonObject)
        if (result.success) {
            TokenInMemory.refreshTokenSignUP(userName, name, result.token)
            saveToken(result.token)
            saveUserName(userName)
            saveName(name)
            saveUserLoginTime()
            return VALUE_SUCCESS
        } else {
            return result.message
        }

    }

    override suspend fun signIn(userName: String, password: String): String {

        val jasonObject = JsonObject().apply {
            addProperty("email", userName)
            addProperty("password", password)
        }

        val result = apiService.singIn(jasonObject)
        if (result.success) {
            TokenInMemory.refreshTokenSignIn(userName, result.token)
            saveToken(result.token)
            saveUserName(userName)
            saveUserLoginTime()
            return VALUE_SUCCESS
        } else {
            return result.message
        }

    }

    override fun signOut() {
        TokenInMemory.refreshTokenSignIn(null, null)
        TokenInMemory.refreshTokenSignUP(null, null, null)
        sharedPref.edit().clear().apply()
    }

    override fun loadToken() {
        TokenInMemory.refreshTokenSignIn(getUserName(), getToken())
        TokenInMemory.refreshTokenSignUP(getUserName(), getName(), getToken())
    }

    override fun saveToken(newToken: String) {
        sharedPref.edit().putString("token", newToken).apply()
    }

    override fun getToken(): String? {
        return sharedPref.getString("token", null)
    }

    override fun saveUserName(userName: String) {
        sharedPref.edit().putString("username", userName).apply()
    }

    override fun getUserName(): String? {
        return sharedPref.getString("username", null)
    }

    override fun saveName(name: String) {
        sharedPref.edit().putString("name", name).apply()
    }

    override fun getName(): String? {
        return sharedPref.getString("name", "")
    }

    override fun saveUserLocation(address: String, postalCode: String) {
        sharedPref.edit().putString("address", address).apply()
        sharedPref.edit().putString("postalCode", postalCode).apply()
    }

    override fun getUserLocation(): Pair<String, String> {
        val address = sharedPref.getString("address", "click to add")!!
        val postalCode = sharedPref.getString("postalCode", "click to add")!!

        return Pair(address, postalCode)
    }

    override fun saveUserLoginTime() {
        val now = System.currentTimeMillis()
        sharedPref.edit().putString("login_time", now.toString()).apply()
    }

    override fun getUserLoginTime(): String {
        return sharedPref.getString("login_time", "0")!!
    }


}