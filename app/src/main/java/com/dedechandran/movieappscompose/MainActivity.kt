package com.dedechandran.movieappscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dedechandran.movieappscompose.presentation.MovieViewModel
import com.dedechandran.movieappscompose.ui.theme.MovieAppsComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppsComposeTheme {
                // A surface container using the 'background' color from the theme
//                val vm: MovieViewModel = viewModel()
//                val uiState = vm.movieUiState.collectAsState()
                Surface(color = MaterialTheme.colors.background) {
//                    if(uiState.value.loading){
//                        Greeting(name = "Loading")
//                    }else if(uiState.value.error){
//                        Greeting(name = "Error")
//                    }else{
//                        Greeting(name = "Success")
//                    }
                    Greeting(name = "Text")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieAppsComposeTheme {
        Greeting("Android")
    }
}