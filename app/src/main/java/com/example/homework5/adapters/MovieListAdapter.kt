package com.example.homework5.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework5.R
import com.example.homework5.base.BaseRecyclerItemClickListener
import com.example.homework5.databinding.RowMovieBinding
import com.example.homework5.ui.movieList.model.Movie

class MovieListAdapter(private val movieList: List<Movie>) :
    RecyclerView.Adapter<MovieViewHolder>() {

    private var itemClickListener: BaseRecyclerItemClickListener<Movie>? = null

    constructor(
        movieList: MutableList<Movie>,
        itemClickListener: BaseRecyclerItemClickListener<Movie>
    ) : this(movieList) {
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = this.movieList[position]
        holder.populate(movie)
        holder.setOnItemClickListener(movie, this.itemClickListener!!)
    }

    override fun getItemCount() = this.movieList.size

}

class MovieViewHolder(private val binding: RowMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun populate(movie: Movie) {
        binding.movie = movie
        binding.executePendingBindings()
    }

    //go to details of clicked id
    fun setOnItemClickListener(
        film: Movie,
        itemClickListener: BaseRecyclerItemClickListener<Movie>?
    ) {
        val view = binding.root
        view.setOnClickListener {
            itemClickListener!!.onItemClicked(film, it.id)
        }
    }
}

