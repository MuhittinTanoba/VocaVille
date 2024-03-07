package com.example.vocaville

import androidx.room.Dao
import androidx.room.Query

@Dao
interface StoriesDao {
    @Query("SELECT * FROM stories")
    suspend fun getAllStories(): List<Stories>
}