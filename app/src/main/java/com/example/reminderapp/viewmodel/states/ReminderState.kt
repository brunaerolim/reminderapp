package com.example.reminderapp.viewmodel.states

import com.example.reminderapp.model.ReminderModel
import com.example.reminderapp.repositories.usecases.AddReminder

data class ReminderState(
    val addReminder: AddReminder,
    val getAllReminders: List<ReminderModel> = emptyList(),
)