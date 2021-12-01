package com.dedechandran.movieappscompose.domain

import com.dedechandran.movieappscompose.data.MovieResponse

data class Movie(
    val id: Long,
    val movieTitle: String,
    val movieOverview: String,
    val movieReleaseDate: String,
    val movieGenres: List<Long>,
    val movieImageUrl: String,
    val movieStatus: String

)

fun MovieResponse.toDomain() = results.map {
    Movie(
        id = it.id,
        movieTitle = it.title.orEmpty(),
        movieOverview = it.overview.orEmpty(),
        movieReleaseDate = it.releaseDate.orEmpty(),
        movieGenres = it.genreIds.orEmpty(),
        movieImageUrl = it.posterPath.orEmpty(),
        movieStatus = it.status.orEmpty()
    )
}
