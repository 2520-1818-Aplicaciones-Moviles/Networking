package com.example.semana4_1_retrofit.model.client

import com.example.semana4_1_retrofit.model.response.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
* This object is responsible for creating and providing a Retrofit instance
* configured to interact with the specified web service.
* It uses the Singleton pattern to ensure that only one instance of the Retrofit client exists throughout the
* application's lifecycle.
*
* @property webService
* */

object RetrofitClient {

    val webService: WebService by lazy {
        Retrofit.Builder()
            //.baseUrl("https://dev.formandocodigo.com/ServicioTour/")
            .baseUrl("https://dev.formandocodigo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WebService::class.java)
    }
    // var service: GitHubService = retrofit.create<GitHubService?>(GitHubService::class.java)
}