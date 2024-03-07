package com.example.vocaville

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Story")
data class Story(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "StoryName") val storyName: String,
    @ColumnInfo(name = "Story") val story: String,
    @ColumnInfo(name = "Date") val date: String,
    @ColumnInfo(name = "Level") val level: String,
    @ColumnInfo(name = "IsReading") val isReading: Int,
    ){}