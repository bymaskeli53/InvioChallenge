package com.example.inviochallenge

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.inviochallenge.databinding.ItemMovieBinding

class MovieAdapter(val movie: Movie,val context: Context): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie) {
            binding.apply {
                textviewCategory.text = movie.Genre
                textviewTitle.text = movie.Title
                textviewYear.text = movie.Year
                ratingbar.rating = movie.imdbRating.toFloat()
                Glide.with(context).load(movie.Poster).into(imageviewCircle)


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val movie = movie
            holder.bind(movie)
    }

    override fun getItemCount(): Int = 1


}