package com.digital.touchvision.presentation.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.digital.touchvision.R
import com.digital.touchvision.presentation.theme.TouchVisionTheme

@Composable
fun StartScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.hello),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
@Preview
private fun StartScreenPreviewLight() {
    TouchVisionTheme {
        StartScreen()
    }
}