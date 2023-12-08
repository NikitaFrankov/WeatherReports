package com.frankov.presentation.screens.cityDetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frankov.data.models.location.Coordinates
import com.frankov.data.models.pojo.Weather
import com.frankov.domain.useCases.home.FetchWeatherUseCase
import com.frankov.presentation.screens.cityDetails.models.CityDetailsUiState
import com.frankov.presentation.screens.cityDetails.models.CurrentWeather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CityDetailsViewModel(
    private val fetchWeatherUseCase: FetchWeatherUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(CityDetailsUiState())
    internal val uiState: StateFlow<CityDetailsUiState> = _uiState.asStateFlow()

    private var coordinates: Coordinates = Coordinates()

    fun fetchWeather() {
        viewModelScope.launch {
            try {
                coordinates = getCoordinates()
                val weather = fetchWeatherUseCase("Moscow")
                val result = CurrentWeather.from(weather ?: Weather())
                _uiState.update {
                    it.copy(weather = result)
                }
            } catch (e: Exception) {
                val message = e.message
                _uiState.update {
                    it.copy(errorMessage = message)
                }
            }
        }
    }

    private fun getCoordinates() = Coordinates(35.895618, 56.854412)
}