package com.example.reminderapp

import android.content.Context
import androidx.room.Room
import com.example.reminderapp.database.ReminderDao
import com.example.reminderapp.database.ReminderDb
import com.example.reminderapp.repositories.ReminderRepository
import com.example.reminderapp.repositories.ReminderRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ReminderDb {
        return Room.databaseBuilder(
            appContext,
            ReminderDb::class.java,
            "reminder_database"
        ).build()
    }

    @Provides
    fun provideReminderDao(database: ReminderDb): ReminderDao {
        return database.reminderDao()
    }

    @Provides
    @Singleton
    fun provideReminderRepository(reminderDao: ReminderDao): ReminderRepository {
        return ReminderRepositoryImpl(reminderDao)
    }
}