package com.example.homework5.repository

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.example.homework5.network.BaseCallBack
import com.example.homework5.network.ServiceConnector
import com.example.homework5.network.response.FavouriteResponse
import com.example.homework5.network.response.MoviesDetailsResponse
import com.example.homework5.network.response.PopularMovieListResponse
import com.example.homework5.utils.API_KEY

class MovieRepository {

    val onMoviesFetched = MutableLiveData<PopularMovieListResponse>()
    val onMoviesDetailsFetched = MutableLiveData<MoviesDetailsResponse>()
    val onFavMoviesFetched = MutableLiveData<FavouriteResponse>()


    //get popular movies service
    fun getAllMovies(apikey: String, page: Int) {

        ServiceConnector.restInterface.getPopularMovies(apikey, "en-US", page)
            .enqueue(object : BaseCallBack<PopularMovieListResponse>() {
                override fun onSuccess(data: PopularMovieListResponse) {
                    onMoviesFetched.postValue(data)
                }
            })
    }

    //get movies details service
    fun getDetailsOfMovies(id: String) {
        ServiceConnector.restInterface.getDetails(id, API_KEY, "en-US")
            .enqueue(object : BaseCallBack<MoviesDetailsResponse>() {
                override fun onSuccess(data: MoviesDetailsResponse) {
                    onMoviesDetailsFetched.postValue(data)
                }

            })
    }

    //adding movie to favourite
    fun getFavouriteMovies(context: Context) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("MovieSharedPref", MODE_PRIVATE)
        //val myEdit = sharedPreferences.edit()
        val list = FavouriteResponse(sharedPreferences.all)
        onFavMoviesFetched.value = list
    }
}