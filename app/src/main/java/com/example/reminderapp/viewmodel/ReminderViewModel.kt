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

    // Define um fluxo de estado para a data selecionada.
    private val _selectedDate = MutableStateFlow<Date?>(null)
    val selectedDate: StateFlow<Date?> get() = _selectedDate

    val reminders = reminderRepository.getAllReminders()

    // Atualiza a data selecionada.
    fun updateSelectedDate(date: Date?) {
        _selectedDate.value = date
    }

    // Adiciona um lembrete.
    fun addReminder(title: String, date: Date) {
        val newReminder = Reminder(id = 0, title = title, date = date)
        viewModelScope.launch {
            reminderRepository.insertReminder(newReminder)
        }
    }

    // Exclui um lembrete.
    fun deleteReminder(reminder: Reminder) {
        viewModelScope.launch {
            reminderRepository.deleteReminder(reminder)
        }
    }
}