package com.example.reminderapp.repositories.usecases

sealed class OrderType  {
    object Ascending : OrderType()
    object Descending : OrderType()
}
