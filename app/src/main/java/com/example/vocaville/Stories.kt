package com.example.vocaville

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "stories")
data class Stories(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "story_id") @NotNull var story_id: Int,
    @ColumnInfo(name = "story_name") @NotNull var story_name: String,
    @ColumnInfo(name = "story_desc") @NotNull var story_desc: String,
    @ColumnInfo(name = "story_date") @NotNull var story_date: String,
    @ColumnInfo(name = "story_level") @NotNull var story_level: String,
    @ColumnInfo(name = "story_IsReading") @NotNull var story_IsReading: Int
) {
}