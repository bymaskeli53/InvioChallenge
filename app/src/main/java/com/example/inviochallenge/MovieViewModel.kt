package com.example.inviochallenge

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    companion object {
        private const val DEFAULT_QUERY = "batman"
    }
     val movieLiveData = MutableLiveData<Movie>()
     val currentQuery = MutableLiveData(DEFAULT_QUERY)




    fun searchMovies(query: String) {
        viewModelScope.launch {
            currentQuery.value = query
           movieLiveData.value = apiService.getMovies(query, "6a3d5acd")


        }
        println(currentQuery.value)
        println(movieLiveData.value)

    }

    fun getMovies() {
        viewModelScope.launch {
            val liveData = apiService.getMovies("batman", "6a3d5acd")
            for (i in liveData.Title) {
                println(i)
            }
        }
    }


}