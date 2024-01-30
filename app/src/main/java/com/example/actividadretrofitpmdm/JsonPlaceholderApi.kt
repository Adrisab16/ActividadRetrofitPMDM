package com.example.actividadretrofitpmdm

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholderApi {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}