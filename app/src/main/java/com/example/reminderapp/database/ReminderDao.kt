package com.example.reminderapp.database

import androidx.room.*
import com.example.reminderapp.model.Reminder
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {
    // Recupera todos os lembretes, ordenados por data.
    @Query("SELECT * FROM reminders ORDER BY date")
    fun getAllReminders(): Flow<List<Reminder>>

    // Insere um lembrete no banco de dados, substituindo-o em caso de conflito.

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(reminder: Reminder)

    // Exclui um lembrete do banco de dados.
    @Delete
    suspend fun deleteReminder(reminder: Reminder)
}
