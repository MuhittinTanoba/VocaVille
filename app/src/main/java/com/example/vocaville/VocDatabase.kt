package com.example.vocaville

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Story::class], version = 1)
abstract class VocDatabase : RoomDatabase() {
    abstract fun storyDao(): StoryDao

    companion object {
        var INSTANCE:VocDatabase? = null
        fun getDatabase(context: Context): VocDatabase? {

            if (INSTANCE == null) {
                synchronized(VocDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        VocDatabase::class.java,
                        "VocaVille.sqlite").createFromAsset("VocaVille.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}