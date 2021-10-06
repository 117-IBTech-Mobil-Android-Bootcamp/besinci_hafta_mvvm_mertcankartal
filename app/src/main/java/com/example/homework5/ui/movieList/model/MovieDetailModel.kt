package com.example.homework5.ui.movieList.model

data class MovieDetailModel(
    val poster_path: String,
    val overwiew: String,
    val release_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val title: String,
    val vote_count: Int,
    val vote_average: Double,
    val popularity: Number
)