package com.example.semana4_1_retrofit.model.response

import com.example.semana4_1_retrofit.model.Sites
import com.example.semana4_1_retrofit.model.Article
import retrofit2.Response
import retrofit2.http.GET

/**
 * This interface defines the web service endpoints for Retrofit.
 * It includes methods to fetch a list of sites and articles from the specified endpoints.
 *
 *
 * @param getSitios
 * A suspend function that performs a GET request to the "sitios.php" endpoint
 * @param getArticles
 * A suspend function that performs a GET request to the "articles.php" endpoint with description=all
 * */

interface WebService {
    @GET("sitios.php")
    suspend fun getSitios(): Response<List<Sites>>

    @GET("articles.php?description=all")
    suspend fun getArticles(): Response<List<Article>>

}