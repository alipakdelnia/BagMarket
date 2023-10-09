package com.example.bagmarket.model.repository

object TokenInMemory {

    var username: String? = null
        private set

    var name: String? = null
        private set

    var token: String? = null
        private set

    fun refreshTokenSignUP(username: String?, name: String?, newToken: String?) {
        this.username = username
        this.name = name
        this.token = newToken
    }

    fun refreshTokenSignIn(username: String?, newToken: String?) {
        this.username = username
        this.token = newToken
    }

}