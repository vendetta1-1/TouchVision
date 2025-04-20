package com.digital.touchvision.presentation.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.digital.touchvision.R
import com.digital.touchvision.presentation.factory.VisionViewModelFactory

@Composable
fun LoadingScreen(
    viewModelFactory: VisionViewModelFactory
) {
    val viewModel: LoadingViewModel = viewModel(factory = viewModelFactory)
    val state = viewModel.state.collectAsState()
    when (val currentState = state.value) {
        LoadingScreenState.Initial -> {
            viewModel.startLoading()
        }

        is LoadingScreenState.Loading -> {
            LoadingScreenContent(currentState.percent)
        }

        LoadingScreenState.Ready -> {
            LoadingScreenContent(100)
        }
    }

}


@Composable
private fun LoadingScreenContent(
    percent: Int
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$percent%",
            color = MaterialTheme.colorScheme.primary,
            style = if (percent == 100) MaterialTheme.typography.bodyLarge else MaterialTheme.typography.titleSmall
        )
        LinearProgressIndicator(
            progress = { percent.toFloat() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            color = MaterialTheme.colorScheme.onPrimary,
            trackColor = MaterialTheme.colorScheme.primary,
            strokeCap = StrokeCap.Round
        )
        Text(
            text = if (percent == 100) stringResource(R.string.bibi_was_ready) else stringResource(R.string.bibi_is_getting_ready_for_work)
        )
    }
}