package com.example.homework5.ui.favourites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.homework5.repository.MovieRepository

class FavouriteViewModel(application:Application):AndroidViewModel(application) {

    val favResponse = MediatorLiveData<FavouriteViewStateModel>()

    private val favRepository = MovieRepository()

    init {
        favRepository.getFavouriteMovies(application)
        favResponse.addSource(favRepository.onFavMoviesFetched){
            favResponse.value = FavouriteViewStateModel(it)
        }
    }

    //getting movies
    fun moviesRepeat(){
        favRepository.getFavouriteMovies(this.getApplication())
    }

}