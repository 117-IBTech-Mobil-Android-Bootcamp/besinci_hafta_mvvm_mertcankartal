package com.example.homework5.ui.movieList

import com.example.homework5.network.response.PopularMovieListResponse
import com.example.homework5.ui.movieList.model.Movie

data class MovieListViewStateModel (val moviesResponse: PopularMovieListResponse){

    fun getResults() : String = "total count ${moviesResponse.total_results}"
    fun getTotalPage() : String = "total page ${moviesResponse.total_pages}"
    fun getList() : List<Movie> = moviesResponse.movies

}