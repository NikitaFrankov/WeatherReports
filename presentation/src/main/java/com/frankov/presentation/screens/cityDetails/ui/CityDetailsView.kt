package com.frankov.presentation.screens.cityDetails.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.frankov.design.theme.Blue
import com.frankov.presentation.R
import com.frankov.presentation.screens.cityDetails.CityDetailsViewModel
import com.frankov.presentation.screens.cityDetails.store.CityDetailsEffect.Navigate.*

@Composable
internal fun HomeView(viewModel: CityDetailsViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column {
        /** Header */
        Column(modifier = Modifier
            .background(
                color = Blue,
                shape = RoundedCornerShape(bottomEnd = 24.dp, bottomStart = 24.dp)
            )
        ) {
            MainToolBar(
                title = state.weather.cityTitle,
                onBackClick = { viewModel.effect(Back) }
            )
            AsyncImage(
                model = state.weather.weatherIconPath,
                contentDescription = "",
                Modifier
                    .height(120.dp)
                    .width(120.dp)
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = state.weather.weatherDescription,
                Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
            Text(
                text = state.weather.time,
                Modifier
                    .padding(top = 16.dp)
                    .padding(bottom = 24.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
        }
        
        /** Description */
        ForecastingView(modifier = Modifier.fillMaxWidth())

        Text(
            text = stringResource(id = R.string.weather_details),
            modifier = Modifier.padding(top = 16.dp, start = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(state.weather.descriptionItems) { item ->
                DescriptionItem(item)
            }
        }
    }
}