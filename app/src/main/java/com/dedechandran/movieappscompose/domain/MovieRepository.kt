package com.dedechandran.movieappscompose.domain

import com.dedechandran.movieappscompose.utils.Result

interface MovieRepository {
    suspend fun getLatestMovies(): Result<List<Movie>>
}