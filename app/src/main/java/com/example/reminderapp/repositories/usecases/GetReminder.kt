package com.example.reminderapp.repositories.usecases

import com.example.reminderapp.model.ReminderModel
import com.example.reminderapp.repositories.ReminderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetReminder(
    private val repository: ReminderRepository
) {
    operator fun invoke(
        reminderOrder: ReminderOrder = ReminderOrder.Date(OrderType.Descending)
    ): Flow<List<ReminderModel>> {
        return repository.getAllReminders().map { _ ->
            when (reminderOrder.orderType) {
                is OrderType.Descending -> {
                    when (reminderOrder) {
                        is ReminderOrder.Date -> listOf()
                    }
                }
                is OrderType.Ascending -> {
                    when (reminderOrder) {
                        is ReminderOrder.Date -> listOf()
                    }
                }
            }

        }
    }
}