package com.example.reminderapp.repositories

import com.example.reminderapp.database.ReminderDao
import com.example.reminderapp.model.Reminder
import javax.inject.Inject
import javax.inject.Singleton

interface ReminderRepository {
    suspend fun getRemindersByDate(date: String): List<Reminder>
    suspend fun addReminder(reminder: Reminder)
    suspend fun deleteReminder(reminder: Reminder)
}

@Singleton
class ReminderRepositoryImpl @Inject constructor(
    private val reminderDao: ReminderDao
) : ReminderRepository {
    override suspend fun getRemindersByDate(date: String): List<Reminder> =
        reminderDao.getRemindersByDate(date)

    override suspend fun addReminder(reminder: Reminder) {
        reminderDao.addReminder(reminder)
    }

    override suspend fun deleteReminder(reminder: Reminder) {
        reminderDao.deleteReminder(reminder)
    }
}

