package com.example.bagmarket.model.repository

interface UserRepository {
    //online with coroutine
    suspend fun signUp(name: String, userName: String, password: String)
    suspend fun signIn(userName: String, password: String)

    //offline
    fun signOut()
    fun loadToken()

    fun saveToken (newToken: String)
    fun getToken() : String

    fun saveUserName(userName: String)
    fun gerUserName():String

}