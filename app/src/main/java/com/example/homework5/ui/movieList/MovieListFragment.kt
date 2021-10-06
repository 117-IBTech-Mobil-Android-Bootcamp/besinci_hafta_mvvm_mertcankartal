package com.example.homework5.ui.movieList


import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.homework5.R
import com.example.homework5.adapters.MovieListAdapter
import com.example.homework5.base.BaseFragment
import com.example.homework5.base.BaseRecyclerItemClickListener
import com.example.homework5.databinding.FragmentMovieListBinding
import com.example.homework5.ui.movieList.model.Movie

class MovieListFragment : BaseFragment<MovieListViewModel,FragmentMovieListBinding> (){

    private val movieList = mutableListOf<Movie>()
    override var viewModel: MovieListViewModel? = null
    private var adapter : MovieListAdapter? = null
    private var position : Int =0

    override fun getLayoutID(): Int =R.layout.fragment_movie_list

    override fun observeLiveData() {
        viewModel?.moviesResponse?.observe(this, {


            dataBinding.popularMovieListResponse = it
            dataBinding.executePendingBindings()
            movieList.addAll(it.getList())
            adapter?.notifyItemRangeChanged(position,movieList.size)
            position+=it.getList().size

    })}

    override fun prepareView() {

        adapter =
            MovieListAdapter(movieList, object : BaseRecyclerItemClickListener<Movie> {
                override fun onItemClicked(clickedObject: Movie, id: Int) {

                    val bundle = bundleOf("movieId" to clickedObject.id.toString())
                    findNavController().navigate(
                        R.id.action_homeFragment_to_detailsFragment, bundle
                    )
                }

            })
        dataBinding.recyclerView.adapter = adapter

        dataBinding.recyclerView.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!dataBinding.recyclerView.canScrollVertically(1) &&
                    newState == RecyclerView.SCROLL_STATE_IDLE
                ) {
                    viewModel?.getMoviesWithPagination()

                }
            }
        })

    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
    }



}