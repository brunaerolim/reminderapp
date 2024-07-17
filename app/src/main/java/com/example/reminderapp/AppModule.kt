package com.example.reminderapp

import androidx.room.Room
import com.example.reminderapp.database.ReminderDb
import com.example.reminderapp.repositories.ReminderRepository
import com.example.reminderapp.viewmodel.ReminderViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Define o banco de dados e o DAO do lembrete.
    single {
        Room.databaseBuilder(get(), ReminderDb::class.java, "reminderdb")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<ReminderDb>().reminderDao() } // Fornece o DAO do lembrete.
    single { ReminderRepository(get()) } // Fornece o repositório do lembrete.
    viewModel { ReminderViewModel(get()) } // Fornece o ViewModel do lembrete.
}
