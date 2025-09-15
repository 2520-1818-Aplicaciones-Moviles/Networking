# Semana4_1_Retrofit

Este proyecto es una aplicación Android desarrollada en Kotlin que utiliza Jetpack Compose para la interfaz de usuario y Retrofit para la comunicación con APIs REST. El objetivo principal es mostrar cómo consumir servicios web de manera eficiente y siguiendo buenas prácticas de arquitectura y programación.

## Estructura del Proyecto

- **model/**: Contiene las clases de datos (DTOs) y el cliente Retrofit.
- **viewModel/**: Incluye los ViewModels que gestionan la lógica de negocio y la obtención de datos.
- **views/**: Componentes Composables para mostrar la información en la UI.
- **MainActivity.kt**: Punto de entrada de la app, donde se integran los ViewModels y las vistas.

## Networking con Retrofit

Retrofit es una librería que facilita la comunicación con APIs REST. En este proyecto:

- Se define una interfaz `WebService` con los endpoints necesarios (`getSitios`, `getArticles`).
- Se crea un cliente singleton (`RetrofitClient`) para asegurar una única instancia de Retrofit.
- Los ViewModels (`SitesViewModel`, `ArticlesViewModel`) utilizan el cliente para obtener datos de forma asíncrona usando corrutinas.

### Ejemplo de llamada a la API
```kotlin
val response = RetrofitClient.webService.getArticles()
if (response.body() != null) {
    articleList = ArrayList(response.body()!!)
}
```

## Buenas Prácticas Implementadas

- **Separación de responsabilidades**: La lógica de negocio está en los ViewModels, la UI en los Composables y la comunicación en el cliente Retrofit.
- **Uso de corrutinas**: Las llamadas de red se realizan en hilos de fondo (Dispatchers.IO) y los resultados se actualizan en el hilo principal (Dispatchers.Main).
- **Mutable State**: Se utiliza `mutableStateOf` para que la UI reaccione automáticamente a los cambios de datos.
- **Patrón Singleton**: El cliente Retrofit se implementa como un singleton para evitar múltiples instancias.
- **Manejo de errores**: Se verifica si la respuesta de la API es nula y se maneja adecuadamente.
- **Uso de DTOs**: Las clases de datos (`Sites`, `Article`, `Source`) representan claramente la estructura esperada de la API.
- **Composables reutilizables**: Las vistas como `Home` y `ArticlesList` son independientes y pueden integrarse fácilmente en diferentes partes de la app.

## Cómo ejecutar

1. Clona el repositorio.
2. Abre el proyecto en Android Studio.
3. Ejecuta la aplicación en un emulador o dispositivo físico.

## Recursos y documentación
- [Retrofit](https://square.github.io/retrofit/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Arquitectura recomendada Android](https://developer.android.com/jetpack/guide)

## Autor
GitHub Copilot

