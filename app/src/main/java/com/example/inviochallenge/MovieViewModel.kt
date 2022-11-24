package com.example.inviochallenge

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {


     val movieLiveData = MutableLiveData<Movie>()





    fun searchMovies(query: String) {
        viewModelScope.launch {

           movieLiveData.value = apiService.getMovies(query, "6a3d5acd")


        }


    }

//    fun getMovies() {
//        viewModelScope.launch {
//            val liveData = apiService.getMovies("batman", "6a3d5acd")
//            for (i in liveData.Title) {
//
//            }
//        }
//    }


}