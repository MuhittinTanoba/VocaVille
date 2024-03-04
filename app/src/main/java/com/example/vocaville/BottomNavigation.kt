package com.example.vocaville

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {

    val selectedPage = remember { mutableStateOf(0) }

    Scaffold(
        content = {PaddingValues ->
            if (selectedPage.value == 0) CategoryScreen(modifier)
            else QuizScreen(modifier)
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ) {
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Categories")
                    },
                    selected = selectedPage.value == 0,
                    onClick = { selectedPage.value = 0 }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Quiz")
                    },
                    selected = selectedPage.value == 1,
                    onClick = { selectedPage.value = 1 }
                )
            }
        }
    )
}