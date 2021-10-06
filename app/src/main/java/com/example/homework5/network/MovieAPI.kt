package com.example.homework5.network

import com.example.homework5.network.response.MoviesDetailsResponse
import com.example.homework5.network.response.PopularMovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {

    //gel popular movies
    @GET("popular")
    fun getPopularMovies(
        @Query("api_key") apikey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<PopularMovieListResponse>

    //get details of movie
    @GET("{movie_id}")
    fun getDetails(
        @Path("movie_id") id : String,
        @Query("api_key") apikey: String,
        @Query("language") language: String,
    ): Call<MoviesDetailsResponse>

}