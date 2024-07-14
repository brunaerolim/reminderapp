package com.example.reminderapp.repositories.usecases

sealed class ReminderOrder(val orderType: OrderType) {

    class Date(orderType: OrderType): ReminderOrder(orderType)
}
