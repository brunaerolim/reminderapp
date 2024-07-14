package com.example.reminderapp.viewmodel.states

import com.example.reminderapp.model.ReminderModel
import kotlinx.coroutines.flow.StateFlow

sealed class ReminderEvent {
    data class DeleteReminder(val reminderModel: ReminderModel) : ReminderEvent()
    data class AddReminder (val reminderModel: ReminderModel) : ReminderEvent()
    data class GetAllReminders(val reminderModel: StateFlow<ReminderModel>) : ReminderEvent()
}
