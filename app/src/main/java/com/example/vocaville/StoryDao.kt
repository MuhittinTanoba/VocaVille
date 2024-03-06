package com.example.vocaville

import androidx.room.Dao
import androidx.room.Query


@Dao
interface StoryDao {
    @Query("SELECT * FROM Story")
    suspend fun getAllStories(): List<Story>
}