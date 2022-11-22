package com.example.inviochallenge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {


    fun getMovies(){
        viewModelScope.launch {
            val liveData = apiService.getMovies("batman","6a3d5acd")
            for (i in liveData.Title) {
                println(i)
            }
        }
    }


}