package com.example.laboratorio05

import android.app.Application
import com.example.laboratorio05.repositories.MovieRepository

import com.example.laboratorio05.data.movies


class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy{


        MovieRepository(movies)
    }


}



