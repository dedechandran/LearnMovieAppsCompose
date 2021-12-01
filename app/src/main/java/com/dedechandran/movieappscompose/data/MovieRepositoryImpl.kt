package com.dedechandran.movieappscompose.data

import com.dedechandran.movieappscompose.domain.Movie
import com.dedechandran.movieappscompose.domain.MovieRepository
import com.dedechandran.movieappscompose.domain.toDomain
import com.dedechandran.movieappscompose.network.NetworkResponse
import com.dedechandran.movieappscompose.utils.ErrorCode
import com.dedechandran.movieappscompose.utils.Result
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieService: MovieService) :
    MovieRepository {
    override suspend fun getLatestMovies(): Result<List<Movie>> {
        val result = movieService.getLatestMovies()
        return when (result) {
            is NetworkResponse.Success -> {
                val data = result.body.toDomain()
                Result.Success(data = data)
            }
            is NetworkResponse.ApiError -> {
                val error = result.body
                Result.Failure(code = result.code, message = error.statusMessage)
            }
            is NetworkResponse.UnknownError -> {
                Result.Failure(code = ErrorCode.ERROR_500.code, message = ErrorCode.ERROR_500.message)
            }
            is NetworkResponse.NetworkError -> {
                Result.Failure(code = ErrorCode.ERROR_500.code, message = ErrorCode.ERROR_500.message)
            }
        }
    }
}
