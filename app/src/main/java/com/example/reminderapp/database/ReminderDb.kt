package com.example.reminderapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.reminderapp.model.Converters
import com.example.reminderapp.model.Reminder

@Database(entities = [Reminder::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ReminderDb : RoomDatabase() {
    abstract fun reminderDao(): ReminderDao
}

