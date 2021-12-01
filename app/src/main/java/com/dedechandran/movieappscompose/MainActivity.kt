package com.dedechandran.movieappscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dedechandran.movieappscompose.presentation.MovieScreen
import com.dedechandran.movieappscompose.ui.theme.MovieAppsComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppsComposeTheme {
                val movieBottomNavItems = listOf(
                    MovieBottomNavItem(
                        label = "Movie",
                        icon = Icons.Filled.Home,
                        screen = Screen.Movie
                    ),
                    MovieBottomNavItem(
                        label = "Tv Show",
                        icon = Icons.Filled.Home,
                        screen = Screen.TvShow
                    ),
                    MovieBottomNavItem(
                        label = "Favorite",
                        icon = Icons.Filled.Favorite,
                        screen = Screen.Favorite
                    )
                )
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        MovieAppBar()
                    },
                    bottomBar = {
                        MovieBottomNavBar(
                            items = movieBottomNavItems,
                            navController = navController
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Movie.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.Movie.route) {
                            // Movie Content
                            Box(modifier = Modifier.fillMaxSize()) {
                                MovieScreen(navController = navController)
                            }
                        }
                        composable(Screen.TvShow.route) {
                            // Tv Show Content
                            Box(modifier = Modifier.fillMaxSize()) {
                                Text("Tv Show Screen")
                            }
                        }
                        composable(Screen.Favorite.route) {
                            // Favorite Content
                            Box(modifier = Modifier.fillMaxSize()) {
                                Text("Favorite Screen")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MovieAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = "Movie Catalogue")
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = ""
                )
            }
        }
    )
}

@Composable
fun MovieBottomNavBar(
    modifier: Modifier = Modifier,
    items: List<MovieBottomNavItem>,
    navController: NavController
) {
    BottomNavigation(modifier = modifier) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == item.screen.route } == true,
                onClick = {
                    navController.navigate(item.screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = "")
                },
                label = {
                    Text(text = item.label)
                }
            )
        }
    }
}

data class MovieBottomNavItem(
    val label: String,
    val icon: ImageVector,
    val screen: Screen
)

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun MovieAppBarPreview() {
    MovieAppBar()
}
