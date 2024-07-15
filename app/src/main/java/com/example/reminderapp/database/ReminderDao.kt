package com.example.reminderapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.reminderapp.model.Reminder

@Dao
interface ReminderDao {
    @Query("SELECT * FROM reminder WHERE date = :date")
    suspend fun getRemindersByDate(date: String): List<Reminder>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addReminder(reminder: Reminder)

    @Delete
    suspend fun deleteReminder(reminder: Reminder)
}