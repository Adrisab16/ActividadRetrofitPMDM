package com.example.actividadretrofitpmdm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun MyScreen() {
    var isLoading by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }
    var posts by remember { mutableStateOf<List<Post>>(emptyList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val coroutineScope = rememberCoroutineScope()

        Button(
            onClick = {
                coroutineScope.launch {
                    try {
                        isLoading = true
                        fetchData {
                            posts = it
                            isLoading = false
                            isError = false
                        }
                    } catch (e: Exception) {
                        // Manejar excepciones
                        isError = true
                        isLoading = false
                        println("Error en la llamada a la API: ${e.message}")
                    }
                }
            },
            enabled = !isLoading
        ) {
            if (isLoading) {
                CircularProgressIndicator()
            } else {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Refrescar")
            }
        }

        if (isLoading) {
            CircularProgressIndicator()
        } else {
            if (isError) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(imageVector = Icons.Default.Warning, contentDescription = null)
                    Text("Error al cargar los datos")
                }
            } else {
                LazyColumn {
                    items(posts) { post ->
                        // Muestra cada elemento de la lista de publicaciones
                        Text(text = post.title)
                        Divider()
                    }
                }
            }
        }
    }
}

suspend fun fetchData(onSuccess: (List<Post>) -> Unit) {
    withContext(Dispatchers.IO) {
        val api = RetrofitInstance.api

        // Realizar la llamada a la API utilizando Retrofit
        val call = api.getPosts()
        val response = call.execute()

        if (response.isSuccessful) {
            val posts = response.body()
            if (posts != null) {
                // Llamamos a la función de éxito con los datos reales de la API
                onSuccess(posts)
            }
        } else {
            // Manejar el error según tus necesidades
            println("Error en la respuesta de la API: ${response.code()}")
            throw Exception("Error en la respuesta de la API: ${response.code()}")
        }
    }
}
