package com.example.homework5.ui.favourites

import com.example.homework5.network.response.FavouriteResponse
import com.example.homework5.ui.movieList.model.FavouriteMovie

class FavouriteViewStateModel(private val favouriteMovieResponse: FavouriteResponse) {
    fun getFavouriteMovies():MutableList<FavouriteMovie>{

        val favList = mutableListOf<FavouriteMovie>()

        favouriteMovieResponse.favouriteMovie.forEach {
            val favouriteMovie = FavouriteMovie(it.key,it.value as String)
            favList.add(favouriteMovie)
        }
        return favList
    }
}