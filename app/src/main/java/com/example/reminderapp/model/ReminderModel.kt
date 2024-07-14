package com.example.reminderapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminder")
data class ReminderModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var date: String,
)

class InvalidReminderException(message: String) : IllegalArgumentException(message)