package com.digital.touchvision.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.digital.touchvision.R
import com.digital.touchvision.presentation.theme.TouchVisionTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onSettingsClickListener: () -> Unit,
    onStartClickListener: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(20.dp),
                navigationIcon = {
                    IconButton(onClick = onSettingsClickListener) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            modifier = Modifier.size(35.dp),
                            contentDescription = stringResource(R.string.settings_content_description),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { values ->
        Column(
            modifier = Modifier.padding(values)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ImageWithText()
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp),
                        shape = RoundedCornerShape(26.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
                        onClick = onStartClickListener,
                    ) {
                        Text(
                            text = stringResource(R.string.start_work).capitalize(Locale.current),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.together_already).uppercase(),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )
                    Text(
                        text = "104",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                    Text(
                        text = stringResource(R.string.days).uppercase(),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
private fun ImageWithText() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_bibi_greeting),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.bibi_name).capitalize(Locale.current),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}


@Composable
@Preview
private fun HomeScreenPreview() {
    TouchVisionTheme {
        HomeScreen(
            onSettingsClickListener = {},
            onStartClickListener = {}
        )
    }
}