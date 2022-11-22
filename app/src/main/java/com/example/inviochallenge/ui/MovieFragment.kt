package com.example.inviochallenge.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.inviochallenge.MovieViewModel
import com.example.inviochallenge.R
import com.example.inviochallenge.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {
    private val viewModel: MovieViewModel by viewModels()
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       val movies =  viewModel.getMovies()
        @Suppress("DEPRECATION")
        setHasOptionsMenu(true)

    }

    @Suppress("DEPRECATION")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.movie_menu, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            @Suppress("")
            override fun onQueryTextSubmit(query: String?): Boolean {
                // This will call retrofit code via viewmodel
                return true

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })

        // Kotlin Dsl kullanmayı unutma
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}