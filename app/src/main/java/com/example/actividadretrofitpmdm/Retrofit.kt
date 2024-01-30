package com.example.actividadretrofitpmdm

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * El objetivo de RetrofitInstance tiene como objetivo proporcionar una
 * instancia única de Retrofit configurada para tu aplicación. Retrofit es
 * una biblioteca de Android que facilita la comunicación con servicios web
 * mediante la conversión de llamadas a API en invocaciones de métodos en
 * una interfaz.
 *
 * Funcionamiento de RetrofitInstance:
 *
 * - RetrofitInstance es un objeto que proporciona una instancia de la interfaz Retrofit (JsonPlaceholderApi).
 * - La URL base para las llamadas a la API JSONPlaceholder se establece como "https://jsonplaceholder.typicode.com/".
 */
object RetrofitInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val api: JsonPlaceholderApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(JsonPlaceholderApi::class.java)
    }
}