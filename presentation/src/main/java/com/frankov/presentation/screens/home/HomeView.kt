package com.frankov.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun HomeView() {
    Column {
        Text(
            text = """
                Stockholm,
                Sweden
            """.trimIndent(),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun HomeScreenPreview() {
    HomeView()
}