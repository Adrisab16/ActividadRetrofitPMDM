package com.example.actividadretrofitpmdm

import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.actividadretrofitpmdm.ui.theme.ActividadRetrofitPMDMTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActividadRetrofitPMDMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}

/*
Explicación del código:

El código proporcionado constituye una aplicación básica en Android con Jetpack Compose y Retrofit
para usar una API REST.

MainActivity y MyScreen:

- MainActivity es la actividad principal de la aplicación Android.
MyScreen es un composable de Jetpack Compose que define la interfaz de usuario de la pantalla principal de la aplicación.

Funcionamiento de MyScreen:

- Al iniciar la aplicación, se muestra un botón llamado "Refrescar" en el centro de la pantalla.
- Al hacer clic en el botón "Refrescar", se simula una llamada a una API (mediante la función fetchData).
- Durante la simulación de la llamada a la API, se muestra un indicador de carga (CircularProgressIndicator).
Una vez completada la simulación, se actualiza la lista de publicaciones (posts) y se muestra en una lista vertical (LazyColumn).

Funcionamiento de fetchData:

- La función fetchData utiliza Retrofit para realizar una llamada a la API REST del servicio JSONPlaceholder (https://jsonplaceholder.typicode.com/posts).
- La llamada se realiza de manera asíncrona en un hilo de fondo (Dispatchers.IO).
- Cuando la llamada es exitosa, se ejecuta la función onSuccess proporcionada como parámetro, que actualiza la lista de publicaciones (posts).
- En caso de error, se maneja imprimiendo un mensaje de error en la consola.

RetrofitInstance:

- RetrofitInstance es un objeto que proporciona una instancia de la interfaz Retrofit (JsonPlaceholderApi).
- La URL base para las llamadas a la API JSONPlaceholder se establece como "https://jsonplaceholder.typicode.com/".

JsonPlaceholderApi y Post:

- JsonPlaceholderApi es una interfaz que define el contrato para las llamadas a la API REST JSONPlaceholder.
- Post es una clase de datos que representa la estructura de un objeto de publicación obtenido de la API.

*/
