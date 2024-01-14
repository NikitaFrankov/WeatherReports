package com.frankov.presentation.screens.cityDetails.ui

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.frankov.design.R
import com.frankov.design.theme.Blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainToolBar(title: String, onBackClick: () -> Unit) {
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
                    painter = painterResource(id = R.drawable.ic_back_white),
                    contentDescription = "Back action",
                    tint = Color.White
                )
            }
        }
    )
}