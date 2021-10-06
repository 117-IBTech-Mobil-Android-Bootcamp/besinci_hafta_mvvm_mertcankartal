package com.example.homework5.network.response

import com.example.homework5.ui.movieList.model.Movie
import com.google.gson.annotations.SerializedName

data class PopularMovieListResponse(
    val page:Int,
    @SerializedName("total_results") val total_results:Int,
    @SerializedName("total_pages") val total_pages:Int,
    @SerializedName("results") val movies:List<Movie>
)
