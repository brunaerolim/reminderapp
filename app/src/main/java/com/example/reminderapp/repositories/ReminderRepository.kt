package com.example.reminderapp.repositories

import com.example.reminderapp.model.Reminder
import com.example.reminderapp.database.ReminderDao
import kotlinx.coroutines.flow.Flow

class ReminderRepository(private val reminderDao: ReminderDao) {
    fun getAllReminders(): Flow<List<Reminder>> = reminderDao.getAllReminders()
    suspend fun insertReminder(reminder: Reminder) = reminderDao.insertReminder(reminder)
    suspend fun deleteReminder(reminder: Reminder) = reminderDao.deleteReminder(reminder)
}
