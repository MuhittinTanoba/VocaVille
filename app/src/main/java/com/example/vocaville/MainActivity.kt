package com.example.vocaville

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.VocaVilleTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VocaVilleTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "home") {
                        composable("home") {
                            HomeScreen(
                                modifier = Modifier.padding(1.dp),
                                onNavigateToCategory = {
                                    navController.navigate("category")
                                },
                                onNavigateToSetting = {
                                    navController.navigate("settings")
                                })
                        }
                        composable("category") {
                            BottomNavigation(
                                modifier = Modifier.padding(paddingValues = innerPadding),
                                onNavigateToStory = {
                                    navController.navigate("story")
                                },
                                navController = navController
                            )
                        }
                        composable("settings") {
                            SettingsScreen(modifier = Modifier.padding(paddingValues = innerPadding))
                        }
                        composable("story") {
                            StoryDetailScreen(
                                modifier = Modifier.padding(paddingValues = innerPadding),
                                navController = navController
                            )
                        }
                    }
                }


                val context = LocalContext.current
                val database = VocDatabase.getDatabase(context)!!
                
                LaunchedEffect(key1 = true) {
                    getAllStories(database)
                }

            }
        }
    }

    fun getAllStories(db: VocDatabase){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            val stories = db.storyDao().getAllStories()

            for(story in stories){
                Log.e("storyId", story.id.toString())
                Log.e("storyName", story.storyName)
                Log.e("storyDescription", story.story)
                Log.e("storyDate", story.date)
                Log.e("storyLevel", story.level)
                Log.e("IsReading", story.isReading.toString())
            }
        }
    }
}



