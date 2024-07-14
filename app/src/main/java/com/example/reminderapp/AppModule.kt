package com.example.reminderapp

import android.app.Application
import androidx.room.Room
import com.example.reminderapp.database.ReminderDb
import com.example.reminderapp.database.ReminderDb.Companion.DATABASE_NAME
import com.example.reminderapp.repositories.ReminderRepository
import com.example.reminderapp.repositories.RepositoryImpl
import com.example.reminderapp.repositories.usecases.AddReminder
import com.example.reminderapp.repositories.usecases.DeleteReminder
import com.example.reminderapp.repositories.usecases.GetReminder
import com.example.reminderapp.repositories.usecases.ReminderUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideReminderDb(app: Application): ReminderDb {
        return Room.databaseBuilder(
            app,
            ReminderDb::class.java,
            DATABASE_NAME
        ).build(
        )
    }

    @Provides
    @Singleton
    fun provideReminderRepository(db: ReminderDb): ReminderRepository {
        return RepositoryImpl(db.reminderDao)
    }

    @Provides
    @Singleton
    fun provideReminderUseCases(repository: ReminderRepository): ReminderUseCase {
        return ReminderUseCase(
            DeleteReminder(repository),
            AddReminder(repository),
            GetReminder(repository)
        )
    }
}