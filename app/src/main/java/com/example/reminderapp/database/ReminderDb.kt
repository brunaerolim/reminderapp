package com.example.reminderapp.database

import com.example.reminderapp.model.Converters
import com.example.reminderapp.model.Reminder
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Reminder::class], version = 1)
@TypeConverters(Converters::class)
abstract class ReminderDb : RoomDatabase() {
    abstract fun reminderDao(): ReminderDao
}
