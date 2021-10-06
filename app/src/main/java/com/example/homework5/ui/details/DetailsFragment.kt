package com.example.homework5.ui.details

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.homework5.R
import com.example.homework5.base.BaseFragment
import com.example.homework5.base.FragmentActions
import com.example.homework5.databinding.FragmentDetailsBinding
import com.example.homework5.utils.toast
import kotlinx.android.synthetic.main.row_movie.*


class DetailsFragment : BaseFragment<DetailsListViewModel, FragmentDetailsBinding>() {

    override fun shouldCheckInternetConnection(): Boolean {
        return true
    }

    var bundleGet: String? = null
    private var title: String? = null
    private var art: Boolean =false

    override var viewModel: DetailsListViewModel? = null

    override fun getLayoutID(): Int = R.layout.fragment_details

    override fun observeLiveData() {


        viewModel?.moviesDetailsResponse?.observe(this, {

            dataBinding.movieDetails = it
            dataBinding.executePendingBindings()

            title = it.getTitle()

            it.getGenres().forEach { genre ->
                val view: View = LayoutInflater.from(requireContext())
                    .inflate(R.layout.row_text, dataBinding.container, false)
                val genreName = view.findViewById<TextView>(R.id.genreText)

                genreName.text = genre.name

                dataBinding.container.addView(view)

            }
        })
    }

    override fun prepareView() {
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("MovieSharedPref", MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        if (sharedPreferences.contains(arguments?.getString("movieId"))) {
            dataBinding.addFavouriteButton.setImageResource(R.drawable.ic_heart_black)
            art=true
            edit.remove(arguments?.getString("movieId"))
            edit.apply()
        } else {
            dataBinding.addFavouriteButton.setImageResource(R.drawable.ic_heart_black_blank)
            art=false
            edit.putString(arguments?.getString("movieId"),title)
            edit.apply()
        }

        dataBinding.addFavouriteButton.setOnClickListener {


            if (art){
                dataBinding.addFavouriteButton.setImageResource(R.drawable.ic_heart_black_blank)
                art=false
                sharedPreferences.edit().remove(arguments?.getString("movieId")).apply()
                edit.remove(arguments?.getString("movieId"))
                edit.commit()
            }else{
                dataBinding.addFavouriteButton.setImageResource(R.drawable.ic_heart_black)
                art=true
                edit.putString(arguments?.getString("movieId"),title)
                edit.apply()
            }

            val myEdit = sharedPreferences.edit()
            myEdit.putString(arguments?.getString("movieId"), title)
            myEdit.apply()
        }


    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(
            this,
            viewModelFactory { DetailsListViewModel(arguments?.getString("movieId")!!) }
        ).get(DetailsListViewModel::class.java)

        bundleGet = arguments?.getString("movieId")

    }


}
/*79if (sharedPreferences.contains(arguments?.getString("movieId"))) {
                dataBinding.addFavouriteButton.setImageResource(R.drawable.ic_heart_blank)

            } else {
                dataBinding.addFavouriteButton.setImageResource(R.drawable.ic_heart_icon_full)
            }*/