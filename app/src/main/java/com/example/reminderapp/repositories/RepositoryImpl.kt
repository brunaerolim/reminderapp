package com.example.reminderapp.repositories

import com.example.reminderapp.database.ReminderDao
import com.example.reminderapp.model.ReminderModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val dao: ReminderDao) : ReminderRepository {
    override suspend fun insertReminder(reminderModel: ReminderModel) {
        return dao.insertReminder(reminderModel)
    }

    override suspend fun deleteReminder(reminderModel: ReminderModel) {
        return dao.deleteReminder(reminderModel)
    }

    override fun getAllReminders(): Flow<List<ReminderModel>> {
        return dao.getAll()
    }
}