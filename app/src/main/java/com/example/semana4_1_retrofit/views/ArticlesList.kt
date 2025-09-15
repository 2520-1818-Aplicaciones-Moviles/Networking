package com.example.semana4_1_retrofit.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.semana4_1_retrofit.model.Article

/**
 * Composable function to display a list of articles in a scrollable column.
 * Each article is shown as a card with image, title, author, and description.
 */
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ArticlesList(articles: ArrayList<Article>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(
                horizontal = 15.dp,
                vertical = 5.dp
            )
        ) {
            items(articles) { article ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    elevation = CardDefaults.elevatedCardElevation(5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        article.urlToImage?.let {
                            GlideImage(
                                model = it,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )
                        }
                        Text(text = "Title: ${article.title}")
                        //Text(text = "Author: ${article.author ?: "Unknown"}")
                        Text(text = "Source: ${article.source.name}")
                        Text(text = "Description: ${article.description ?: "No description"}")
                    }
                }
            }
        }
    }
}

