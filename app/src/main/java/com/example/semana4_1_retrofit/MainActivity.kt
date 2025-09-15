package com.example.semana4_1_retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import com.example.semana4_1_retrofit.ui.theme.Semana4_1_retrofitTheme
import com.example.semana4_1_retrofit.viewModel.ArticlesViewModel
import com.example.semana4_1_retrofit.viewModel.SitesViewModel
import com.example.semana4_1_retrofit.views.ArticlesList
import com.example.semana4_1_retrofit.views.Home

class MainActivity : ComponentActivity() {

    val sitesViewModel by viewModels<SitesViewModel>()
    val articlesViewModel by viewModels<ArticlesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Semana4_1_retrofitTheme {
                //sitesViewModel.getSites()
                articlesViewModel.getArticles()
                Column {
                    //Text(text = "Sitios:")
                    //Home(sitesViewModel.siteList)
                    //Text(text = "Artículos:")
                    ArticlesList(articlesViewModel.articleList)
                }
            }
        }
    }
}
