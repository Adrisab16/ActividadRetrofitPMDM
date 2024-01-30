package com.example.actividadretrofitpmdm

import retrofit2.Call
import retrofit2.http.GET

/**
 * JsonPlaceholderApi es una interfaz que define el contrato para las llamadas a la API REST JSONPlaceholder.
 */

interface JsonPlaceholderApi {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}