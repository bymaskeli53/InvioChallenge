package com.example.inviochallenge.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.inviochallenge.DetailsViewModel
import com.example.inviochallenge.R
import com.example.inviochallenge.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {
    private val args by navArgs<DetailsFragmentArgs>()
    private val viewModel: DetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailsBinding.bind(view)

        binding.apply {
            textviewAwards.text = args.model.Awards
            textviewPlot.text = args.model.Plot
            textviewTitle.text = args.model.Title
            viewModel.getImage(args.model.Poster,imageview)

        }
    }

}