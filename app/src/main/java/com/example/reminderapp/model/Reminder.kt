package com.example.reminderapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.util.Date

@Entity(tableName = "reminders")
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    val id: Int, // Identificador único do lembrete.
    val title: String,  // Título do lembrete.
    val date: Date // Data do lembrete.
)

class Converters {
    // Converte a data para um valor numérico.
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    // Converte um valor numérico para a data.
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}