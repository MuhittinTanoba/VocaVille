package com.example.vocaville

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Stories::class], version = 1)
abstract class Vocdatabase : RoomDatabase() {
    abstract fun storiesDao(): StoriesDao

    companion object{
        var INSTANCE: Vocdatabase? = null
        fun getDatabase(context: Context): Vocdatabase? {
            if (INSTANCE == null) {

                synchronized(Vocdatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Vocdatabase::class.java,
                        "story.sqlite").createFromAsset("story.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}