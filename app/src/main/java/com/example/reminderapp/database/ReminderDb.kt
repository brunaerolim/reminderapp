package com.example.reminderapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.reminderapp.model.Reminder

@Database(entities = [Reminder::class], version = 1,  exportSchema = false)
abstract class ReminderDb : RoomDatabase() {
    abstract fun reminderDao(): ReminderDao
}
