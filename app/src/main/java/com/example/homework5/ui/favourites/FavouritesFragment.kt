package com.example.homework5.ui.favourites

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.homework5.R
import com.example.homework5.adapters.FavouriteAdapter
import com.example.homework5.base.BaseFragment
import com.example.homework5.databinding.FragmentFavouritesBinding
import com.example.homework5.ui.movieList.model.FavouriteMovie
import kotlinx.android.synthetic.main.fragment_favourites.*

class FavouritesFragment : BaseFragment<FavouriteViewModel, FragmentFavouritesBinding>() {

    private var favList = mutableListOf<FavouriteMovie>()
    override var viewModel: FavouriteViewModel? = null

    override fun getLayoutID(): Int = R.layout.fragment_favourites

    override fun observeLiveData() {

        viewModel?.favResponse?.observe(this) {
            dataBinding.movie = it
            dataBinding.executePendingBindings()
            favList = it.getFavouriteMovies()

            dataBinding.recyclerView.adapter = FavouriteAdapter(favList)
        }


    }

    override fun prepareView() {
        viewModel?.moviesRepeat()
        if (favList.size == 0){
            textView.text="No Selected Movie"
            textView.visibility= View.VISIBLE
            recyclerView.visibility = View.GONE
        }else{
            textView.visibility= View.GONE
            recyclerView.visibility = View.VISIBLE
        }

    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(FavouriteViewModel::class.java)
    }

}