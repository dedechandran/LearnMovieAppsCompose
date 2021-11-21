package com.dedechandran.movieappscompose.data

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val results: List<MovieItem>
) {
    data class MovieItem(
        @SerializedName("id")
        val id: Long,
        @SerializedName("title")
        val title: String?,
        @SerializedName("status")
        val status: String?,
        @SerializedName("poster_path")
        val posterPath: String?,
        @SerializedName("overview")
        val overview: String?,
        @SerializedName("genre_ids")
        val genreIds: List<Long>?,
        @SerializedName("release_data")
        val releaseDate: String?
    )
}