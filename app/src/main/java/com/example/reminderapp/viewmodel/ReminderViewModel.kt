package com.example.reminderapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reminderapp.model.Reminder
import com.example.reminderapp.repositories.ReminderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Date

class ReminderViewModel(private val reminderRepository: ReminderRepository) : ViewModel() {
    private val _selectedDate = MutableStateFlow<Date?>(null)
    val selectedDate: StateFlow<Date?> get() = _selectedDate

    val reminders = reminderRepository.getAllReminders()

    fun updateSelectedDate(date: Date) {
        _selectedDate.value = date
    }

    fun addReminder(title: String, date: Date) {
        val newReminder = Reminder(id = 0, title = title, date = date)
        viewModelScope.launch {
            reminderRepository.insertReminder(newReminder)
        }
    }

    fun deleteReminder(reminder: Reminder) {
        viewModelScope.launch {
            reminderRepository.deleteReminder(reminder)
        }
    }
}

