package com.frankov.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.frankov.design.R as Design

@Composable
internal fun HomeView() {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = """
                Stockholm,
                Sweden
            """.trimIndent(),
            modifier = Modifier
                .padding(top = 8.dp),
            style = MaterialTheme.typography.titleLarge,
        )

        Text(
            text = "Tue, Jun 30",
            modifier = Modifier
                .padding(top = 6.dp),
            style = MaterialTheme.typography.bodyMedium
        )

        Image(
            painterResource(id = Design.drawable.ic_weather_cludy),
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun HomeScreenPreview() {
    HomeView()
}