package com.example.reminderapp.viewmodel.states

import com.example.reminderapp.model.ReminderModel
import com.example.reminderapp.repositories.usecases.AddReminder

data class ReminderState(
    //passando o useCase para o estado
    val addReminder: AddReminder,
    val getAllReminders: List<ReminderModel> = emptyList(),
)