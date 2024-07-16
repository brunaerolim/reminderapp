package com.example.reminderapp

import android.app.Application
import androidx.room.Room
import com.example.reminderapp.database.ReminderDao
import com.example.reminderapp.database.ReminderDb
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
    fun provideDatabase(app: Application): ReminderDb {
        return Room.databaseBuilder(app, ReminderDb::class.java, "reminderdb")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    fun provideReminderDao(db: ReminderDb): ReminderDao = db.reminderDao()
}
