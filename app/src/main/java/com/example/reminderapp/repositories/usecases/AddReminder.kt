package com.example.reminderapp.repositories.usecases

import com.example.reminderapp.model.InvalidReminderException
import com.example.reminderapp.model.ReminderModel
import com.example.reminderapp.repositories.ReminderRepository

class AddReminder(
    private val repository: ReminderRepository
) {
    @Throws(InvalidReminderException::class)
    suspend fun invoke(reminderModel: ReminderModel) {
        if (reminderModel.title.isBlank() || reminderModel.date.isBlank()) {
            throw InvalidReminderException("O titulo e a data não podem ser vazios")
        } else {
            repository.insertReminder(reminderModel)
        }
    }
}