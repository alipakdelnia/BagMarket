package com.example.bagmarket.model.net

import com.example.bagmarket.model.data.LoginResponsed
import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST
    suspend fun signUp(@Body jsonObject: JsonObject):LoginResponsed

    @POST
    suspend fun singIn(@Body jsonObject: JsonObject):LoginResponsed

}