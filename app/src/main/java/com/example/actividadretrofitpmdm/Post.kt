package com.example.actividadretrofitpmdm

/**
 * Post es una clase de datos que representa la estructura de un objeto de publicación obtenido de la API.
 */

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)