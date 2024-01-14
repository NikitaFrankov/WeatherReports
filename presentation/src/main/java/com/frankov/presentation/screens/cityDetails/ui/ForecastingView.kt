package com.frankov.presentation.screens.cityDetails.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frankov.design.theme.Blue
import com.frankov.design.theme.White
import com.frankov.presentation.R


@Composable
internal fun ForecastingView(modifier: Modifier) {
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