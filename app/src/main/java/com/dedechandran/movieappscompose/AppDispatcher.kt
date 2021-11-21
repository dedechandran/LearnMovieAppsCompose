package com.dedechandran.movieappscompose

import com.dedechandran.movieappscompose.di.DispatcherDefault
import com.dedechandran.movieappscompose.di.DispatcherIO
import com.dedechandran.movieappscompose.di.DispatcherMain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class AppDispatcher @Inject constructor(
    @DispatcherIO val dispatcherIO: CoroutineDispatcher,
    @DispatcherMain val dispatcherMain: CoroutineDispatcher,
    @DispatcherDefault val dispatcherDefault: CoroutineDispatcher
)
