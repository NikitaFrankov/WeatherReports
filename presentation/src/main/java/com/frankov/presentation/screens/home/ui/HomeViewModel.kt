package com.frankov.presentation.screens.home.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frankov.data.network.models.location.Coordinates
import com.frankov.domain.useCases.home.FetchWeatherUseCase
import com.frankov.presentation.screens.home.models.HomeUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel(
    private val fetchWeatherUseCase: FetchWeatherUseCase
): ViewModel() {
    internal var uiState by mutableStateOf(HomeUiState())
        private set

    private var coordinates: Coordinates = Coordinates()

    private var fetchJob: Job? = null

    fun fetchArticles() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            uiState = try {
                val weather = fetchWeatherUseCase(coordinates)
                uiState.copy(weather = weather)
            } catch (e: Exception) {
                val message = e.message
                uiState.copy(errorMessage = message)
            }
        }
    }
}