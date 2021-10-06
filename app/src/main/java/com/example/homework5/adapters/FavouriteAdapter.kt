package com.example.homework5.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework5.R
import com.example.homework5.databinding.RowFavBinding
import com.example.homework5.ui.movieList.model.FavouriteMovie

class FavouriteAdapter(private val favList:MutableList<FavouriteMovie>):RecyclerView.Adapter<FavViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        return FavViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_fav,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holderFav: FavViewHolder, position: Int) {
        val movie = this.favList[position]
        holderFav.populate(movie)
    }

    override fun getItemCount(): Int = favList.size
}

class FavViewHolder(private val binding:RowFavBinding):RecyclerView.ViewHolder(binding.root){

    fun populate(favMovie: FavouriteMovie) {
        binding.movie = favMovie
        binding.executePendingBindings()
    }
}