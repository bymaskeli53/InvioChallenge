package com.example.inviochallenge.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.inviochallenge.Movie
import com.example.inviochallenge.MovieAdapter
import com.example.inviochallenge.MovieViewModel
import com.example.inviochallenge.R
import com.example.inviochallenge.databinding.FragmentMovieBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie),MovieAdapter.OnItemClickListener {
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
        viewModel.movieLiveData.observe(viewLifecycleOwner){
            val adapter = MovieAdapter(viewModel.movieLiveData.value!!,requireContext(),this@MovieFragment)
            binding.recyclerview.adapter = adapter
            if (adapter.itemCount == 0) {
                Snackbar.make(view,"There is no data",Snackbar.LENGTH_LONG).show()
            }

        }
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

//                binding.animationView.visibility = View.VISIBLE
//                binding.animationView.setAnimation(R.raw.loading2)
//                binding.animationView.playAnimation()

                if (query != null) {
                    viewModel.searchMovies(query)
                   // binding.animationView.pauseAnimation()
                   // binding.animationView.visibility = View.INVISIBLE
//                    binding.animationView.pauseAnimation()
//                    binding.animationView.setImageDrawable(null)

                }
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

    override fun onItemClick(movie: Movie) {
        val action = MovieFragmentDirections.actionMovieFragmentToDetailsFragment(movie)
        findNavController().navigate(action)

    }


}