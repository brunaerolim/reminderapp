package com.example.reminderapp.repositories.usecases

data class ReminderUseCase(
    val deleteReminder: DeleteReminder,
    val addReminder: AddReminder,
    val getReminder: GetReminder,
)