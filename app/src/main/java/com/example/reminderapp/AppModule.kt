package com.example.reminderapp

import androidx.room.Room
import com.example.reminderapp.database.ReminderDb
import com.example.reminderapp.repositories.ReminderRepository
import com.example.reminderapp.viewmodel.ReminderViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(get(), ReminderDb::class.java, "reminderdb")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<ReminderDb>().reminderDao() }
    single { ReminderRepository(get()) }
    viewModel { ReminderViewModel(get()) }
}
