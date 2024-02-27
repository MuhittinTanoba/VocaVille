package com.example.vocaville

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    modifier: Modifier,
    onNavigateToCategory: () -> Unit,
    onNavigateToSetting: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(modifier) {
            Header(modifier = modifier)

            Column(
                modifier = modifier
                    .padding(top = 100.dp)
                    .align(
                        Alignment.CenterHorizontally
                    )
            ) {
                StartButton(
                    onClick = { onNavigateToCategory() },
                    modifier = modifier.align(Alignment.CenterHorizontally)
                )
                SettingButton(onClick = { onNavigateToSetting() })
            }
        }
    }
}

@Composable
fun Header(modifier: Modifier) {
    Text(
        fontSize = 40.sp,
        text = "VocaVille"
    )
}

@Composable
fun StartButton(onClick: () -> Unit, modifier: Modifier) {
    Button(onClick = { onClick() }, modifier = modifier) {
        Text(text = "Start")
    }
}

@Composable
fun SettingButton(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text(text = "Setting")
    }
}

