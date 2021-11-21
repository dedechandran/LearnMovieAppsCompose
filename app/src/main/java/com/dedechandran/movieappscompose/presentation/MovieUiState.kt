package com.dedechandran.movieappscompose.presentation

import com.dedechandran.movieappscompose.domain.Movie

data class MovieUiState(
    val loading: Boolean = false,
    val movieList: List<Movie> = emptyList(),
    val error: Boolean = false
)
