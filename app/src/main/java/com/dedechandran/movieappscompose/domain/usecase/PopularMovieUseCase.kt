package com.dedechandran.movieappscompose.domain.usecase

import com.dedechandran.movieappscompose.AppDispatcher
import com.dedechandran.movieappscompose.domain.Movie
import com.dedechandran.movieappscompose.domain.MovieRepository
import com.dedechandran.movieappscompose.utils.Result
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val appDispatcher: AppDispatcher
) {

    suspend operator fun invoke(): Result<List<Movie>> {
        return withContext(appDispatcher.dispatcherIO) {
            movieRepository.getLatestMovies()
        }
    }
}
