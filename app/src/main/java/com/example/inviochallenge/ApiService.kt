package com.example.inviochallenge

import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    companion object {
        const val BASE_URL = "https://www.omdbapi.com/"
    }

    // get işlemini tamamla
    @GET(".")
    suspend fun getMovies(
        @Query("t") title: String,
        @Query("apikey") apikey: String

        ): Movie
}