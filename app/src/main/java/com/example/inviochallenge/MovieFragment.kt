package com.example.inviochallenge

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.inviochallenge.databinding.FragmentMovieBinding

class MovieFragment : Fragment(R.layout.fragment_movie) {
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