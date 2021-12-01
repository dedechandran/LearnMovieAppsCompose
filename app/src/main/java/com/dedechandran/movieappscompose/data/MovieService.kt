package com.dedechandran.movieappscompose.data

import com.dedechandran.movieappscompose.network.GenericResponse
import retrofit2.http.GET

interface MovieService {

    @GET("movie/popular")
    suspend fun getLatestMovies(): GenericResponse<MovieResponse>
}
