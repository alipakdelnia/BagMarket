package com.example.bagmarket.model.net

import com.example.bagmarket.model.data.AdsResponse
import com.example.bagmarket.model.data.CommentsResponse
import com.example.bagmarket.model.data.LoginResponsed
import com.example.bagmarket.model.data.ProductResponse
import com.example.bagmarket.model.repository.TokenInMemory
import com.example.bagmarket.util.BASE_URL
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("signUp")
    suspend fun signUp(@Body jsonObject: JsonObject):LoginResponsed

    @POST("signIn")
    suspend fun singIn(@Body jsonObject: JsonObject):LoginResponsed

    @GET("refreshToken")
    fun refreshToken() : Call<LoginResponsed>

    @GET("getProducts")
    suspend fun getAllProducts() : ProductResponse

    @GET("getSliderPics")
    suspend fun getAllAds():AdsResponse

    @POST("getComments")
    suspend fun getAllComments(@Body jsonObject: JsonObject): CommentsResponse


}

fun createApiService():ApiService{
     val okHttpClient = OkHttpClient.Builder()
         .addInterceptor{

             val oldRequest = it.request()

             val newRequest = oldRequest.newBuilder()
             if (TokenInMemory.token != null)
                 newRequest.addHeader("Authorization",TokenInMemory.token!!)

             newRequest.addHeader("Accept","application/json")
             newRequest.method(oldRequest.method,oldRequest.body)


             return@addInterceptor it.proceed(newRequest.build())
         }.build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    return retrofit.create(ApiService::class.java)

}