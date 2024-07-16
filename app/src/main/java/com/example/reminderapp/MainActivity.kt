package com.example.reminderapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.reminderapp.ui.theme.ReminderappTheme
import com.example.reminderapp.ui.theme.uilayer.ReminderScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReminderappTheme {
                ReminderScreen()
            }
        }
    }
}
