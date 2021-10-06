package com.example.homework5.network.response

import com.example.homework5.ui.movieList.model.Genre

data class MoviesDetailsResponse (
    val id:Int,
    val title:String,
    val vote_average:Number,
    val vote_count:Int,
    val release_date:String,
    val overview:String,
    val poster_path:String,
    val popularity:Number,
    val runtime:Int,
    val genres:Array<Genre>,
    val adult:Boolean
)