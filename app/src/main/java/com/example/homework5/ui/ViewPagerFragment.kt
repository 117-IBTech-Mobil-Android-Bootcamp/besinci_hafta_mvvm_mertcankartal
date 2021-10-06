package com.example.homework5.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework5.R
import com.example.homework5.adapters.TablayoutAdapter
import com.example.homework5.ui.favourites.FavouritesFragment
import com.example.homework5.ui.movieList.MovieListFragment
import kotlinx.android.synthetic.main.fragment_home.*

class ViewPagerFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //create an adapter object for viewPager and adding fragments and their titles
        val adapter = TablayoutAdapter(childFragmentManager)
        adapter.addFragment(MovieListFragment(), "Movies")
        adapter.addFragment(FavouritesFragment(), "Favourites")
        //adapter connection
        viewPager.adapter = adapter
        //switch between tabs
        tabLayout.setupWithViewPager(viewPager)

    }

}