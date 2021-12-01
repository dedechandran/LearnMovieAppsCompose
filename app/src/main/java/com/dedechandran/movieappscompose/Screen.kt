package com.dedechandran.movieappscompose

sealed class Screen(val route: String) {
    object Movie : Screen("movie")
    object TvShow : Screen("tvshow")
    object Favorite : Screen("favorite")
}
