package com.frankov.weatherreports.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.frankov.design.theme.WeatherReportsTheme
import com.frankov.presentation.navigation.NavigationAppHost
import com.frankov.presentation.navigation.NavigationFactory
import org.koin.androidx.compose.get

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // UI
        setContent {
            WeatherReportsTheme {
                SetupSurface()
            }
        }
    }
}

@Composable
fun SetupSurface() {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        get<NavigationFactory>().Create()
        NavigationAppHost()
    }
}