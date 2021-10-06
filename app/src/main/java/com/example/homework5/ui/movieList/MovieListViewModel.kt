package com.example.homework5.ui.movieList

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.homework5.repository.MovieRepository
import com.example.homework5.utils.API_KEY

class MovieListViewModel : ViewModel() {

    val moviesResponse = MediatorLiveData<MovieListViewStateModel>()
    val movieRepository = MovieRepository()
    var page = 1

    init {
        movieRepository.getAllMovies(API_KEY,page)

        moviesResponse.addSource(movieRepository.onMoviesFetched) {
            moviesResponse.value = MovieListViewStateModel(it)
        }
    }

    fun getMoviesWithPagination(){
        movieRepository.getAllMovies(API_KEY,++page)
    }
}