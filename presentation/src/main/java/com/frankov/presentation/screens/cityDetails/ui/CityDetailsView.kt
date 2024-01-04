package com.frankov.presentation.screens.cityDetails.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.frankov.design.theme.Blue
import com.frankov.design.theme.White
import com.frankov.design.R as Design
import com.frankov.presentation.R
import com.frankov.presentation.screens.cityDetails.models.WeatherDescription
import com.frankov.presentation.screens.cityDetails.models.WeatherDescription.*

@Composable
internal fun HomeView(viewModel: CityDetailsViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

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
                onBackClick = viewModel::fetchWeather
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

@Composable
private fun ForecastingView(modifier: Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val titleIds by remember {
        mutableStateOf(
            listOf(
                R.string.forecast_yesterday,
                R.string.forecast_today,
                R.string.forecast_tomorrow,
            )
        )
    }
    Column(
        modifier = modifier.then(
            Modifier
                .background(color = White, shape = RoundedCornerShape(20.dp))
                .padding(horizontal = 16.dp)
        )
    ) {
        TabRow(
            selectedTabIndex = selectedIndex,
            indicator = {},
            divider = {},
        ) {
            titleIds.forEachIndexed { index, titleId ->
                Tab(
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    modifier = Modifier
                        .height(40.dp)
                        .clip(RoundedCornerShape(56))
                        .background(if (selectedIndex == index) Blue else White),
                    text = {
                        Text(
                            text = stringResource(id = titleIds[index]),
                            fontSize = 16.sp,
                        )
                    },
                    selectedContentColor = White,
                    unselectedContentColor = Blue,
                )
            }
        }
    }
}

@Composable
private fun DescriptionItem(
    item: WeatherDescription
) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 4.dp
    ) {
        val iconId = when(item) {
            is UltravioletIndex -> Design.drawable.ic_uv_undex
            is Temperature -> Design.drawable.ic_temperature
            is Humidity -> Design.drawable.ic_humidity
            is WindSpeed -> Design.drawable.ic_wind
        }
        val title = when(item) {
            is Temperature -> stringResource(id = R.string.temperature_сelsius)
            is UltravioletIndex -> stringResource(id = R.string.uv_index)
            is WindSpeed -> stringResource(id = R.string.pressure)
            is Humidity -> stringResource(id = R.string.humidity)
        }

        Row(modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = null
            )
            Column(modifier = Modifier.padding(start = 8.dp),) {
                Text(text = item.value)
                Text(text = title)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainToolBar(title: String, onBackClick: () -> Unit) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Blue,
            titleContentColor = Color.White,
        ),
        title = {
            Text(
                text = title,
                color = Color.White,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onBackClick
            ) {
                Icon(
                    painter = painterResource(id = Design.drawable.ic_back_white),
                    contentDescription = "Back action",
                    tint = Color.White
                )
            }
        }
    )
}