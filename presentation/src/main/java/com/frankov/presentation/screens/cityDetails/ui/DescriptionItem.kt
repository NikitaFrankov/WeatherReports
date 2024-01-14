package com.frankov.presentation.screens.cityDetails.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.frankov.data.models.weather.WeatherDescription
import com.frankov.design.R

@Composable
internal fun DescriptionItem(
    item: WeatherDescription
) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 4.dp
    ) {
        val iconId = when(item) {
            is WeatherDescription.UltravioletIndex -> R.drawable.ic_uv_undex
            is WeatherDescription.Temperature -> R.drawable.ic_temperature
            is WeatherDescription.Humidity -> R.drawable.ic_humidity
            is WeatherDescription.WindSpeed -> R.drawable.ic_wind
        }
        val title = when(item) {
            is WeatherDescription.Temperature -> stringResource(id = com.frankov.presentation.R.string.temperature_сelsius)
            is WeatherDescription.UltravioletIndex -> stringResource(id = com.frankov.presentation.R.string.uv_index)
            is WeatherDescription.WindSpeed -> stringResource(id = com.frankov.presentation.R.string.pressure)
            is WeatherDescription.Humidity -> stringResource(id = com.frankov.presentation.R.string.humidity)
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