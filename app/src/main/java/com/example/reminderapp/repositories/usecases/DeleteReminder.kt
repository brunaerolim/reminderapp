package com.example.reminderapp.repositories.usecases

import com.example.reminderapp.model.ReminderModel
import com.example.reminderapp.repositories.ReminderRepository

class DeleteReminder(
    private val repository: ReminderRepository
) {
    suspend operator fun invoke(reminderModel: ReminderModel) {
        repository.deleteReminder(reminderModel)
    }
}