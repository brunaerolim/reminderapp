package com.example.reminderapp.repositories

import com.example.reminderapp.model.Reminder
import com.example.reminderapp.database.ReminderDao
import kotlinx.coroutines.flow.Flow

class ReminderRepository(private val reminderDao: ReminderDao) {
    // Retorna todos os lembretes.
    fun getAllReminders(): Flow<List<Reminder>> = reminderDao.getAllReminders()
    // Insere um lembrete no banco de dados.
    suspend fun insertReminder(reminder: Reminder) = reminderDao.insertReminder(reminder)
    // Exclui um lembrete do banco de dados.
    suspend fun deleteReminder(reminder: Reminder) = reminderDao.deleteReminder(reminder)
}
