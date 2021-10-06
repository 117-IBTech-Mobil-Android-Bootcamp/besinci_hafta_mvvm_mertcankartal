package com.example.homework5.ui.details

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.homework5.repository.MovieRepository
import com.example.homework5.utils.API_KEY

class DetailsListViewModel(id:String) : ViewModel() {

    val moviesDetailsResponse = MediatorLiveData<DetailsListViewStateModel>()
    val movieDetailsRepository = MovieRepository()

    init {

            movieDetailsRepository.getDetailsOfMovies(id)

            moviesDetailsResponse.addSource(movieDetailsRepository.onMoviesDetailsFetched) {
                moviesDetailsResponse.value = DetailsListViewStateModel(it)
            }

    }


}