package com.example.semana4_1_retrofit.model

/**
 * This data class represents a news article with various attributes.
 *
 * @param source The source of the article.
 * @param author The author of the article (nullable).
 * @param title The title of the article.
 * @param description A brief description of the article (nullable).
 * @param url The URL to the full article.
 * @param urlToImage The URL to the image associated with the article (nullable).
 * @param publishedAt The publication date of the article (nullable).
 * @param content The main content of the article (nullable).
 *
 * */

data class Article(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)
