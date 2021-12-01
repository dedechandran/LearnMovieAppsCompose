package com.dedechandran.movieappscompose.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dedechandran.movieappscompose.domain.Movie

@ExperimentalMaterialApi
@Composable
fun MovieScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    vm: MovieViewModel = hiltViewModel()
) {
    val movieState = vm.movieUiState.collectAsState()
    val isLoading by remember {
        derivedStateOf {
            movieState.value.loading
        }
    }

    AnimatedVisibility(visible = isLoading) {
        CircularProgressIndicator()
    }
    LazyColumn {
        items(movieState.value.movieList) {
            ListItem(
                text = {
                    Text(text = it.movieTitle)
                }
            )
        }
    }
}