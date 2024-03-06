package com.example.vocaville

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    onNavigateToStory: () -> Unit,
    navController: NavHostController
) {

    val selectedPage = remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(text = "VocaVille")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        if(selectedPage.value == 0) navController.navigateUp()
                        else selectedPage.value = 0
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
        content = { PaddingValues ->
            if (selectedPage.value == 0) CategoryScreen(
                modifier = Modifier.padding(PaddingValues),
                onNavigateToStory = onNavigateToStory
            )
            else QuizScreen(modifier = Modifier.padding(PaddingValues))
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