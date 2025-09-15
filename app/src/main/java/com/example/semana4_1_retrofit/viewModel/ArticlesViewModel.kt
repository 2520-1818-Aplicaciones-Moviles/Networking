package com.example.semana4_1_retrofit.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semana4_1_retrofit.model.Article
import com.example.semana4_1_retrofit.model.client.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.collections.arrayListOf

/**
 * ViewModel for managing and fetching articles from the API.
 */
class ArticlesViewModel : ViewModel() {
    var articleList: ArrayList<Article> by mutableStateOf(arrayListOf())

    fun getArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getArticles()
            withContext(Dispatchers.Main) {
                if (response.body() != null) {
                    articleList = ArrayList(response.body()!!)
                } else {
                    articleList = arrayListOf()
                }
            }
        }
    }
}

