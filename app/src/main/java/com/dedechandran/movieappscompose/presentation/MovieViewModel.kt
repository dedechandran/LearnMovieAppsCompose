package com.dedechandran.movieappscompose.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dedechandran.movieappscompose.domain.usecase.PopularMovieUseCase
import com.dedechandran.movieappscompose.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val getPopularMovieUseCase: PopularMovieUseCase) : ViewModel() {

    val movieUiState = MutableStateFlow(MovieUiState(loading = true))

    init {
        viewModelScope.launch {
            val result = getPopularMovieUseCase.invoke()
            when (result) {
                is Result.Success -> {
                    movieUiState.value = movieUiState.value.copy(
                        loading = false,
                        movieList = result.data,
                        error = false
                    )
                }
                is Result.Failure -> {
                    movieUiState.value = movieUiState.value.copy(
                        loading = false,
                        movieList = emptyList(),
                        error = true
                    )
                }
            }
        }
    }
}
