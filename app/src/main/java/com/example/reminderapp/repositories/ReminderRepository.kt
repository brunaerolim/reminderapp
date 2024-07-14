package com.example.reminderapp.repositories

import com.example.reminderapp.model.ReminderModel
import kotlinx.coroutines.flow.Flow

interface ReminderRepository {

    suspend fun insertReminder(reminderModel: ReminderModel)

    suspend fun deleteReminder(reminderModel: ReminderModel)

    fun getAllReminders(): Flow<List<ReminderModel>>
}