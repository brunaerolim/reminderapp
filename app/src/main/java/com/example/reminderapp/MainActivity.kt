package com.example.reminderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.reminderapp.ui.theme.ReminderappTheme
import com.example.reminderapp.ui.theme.uilayer.ReminderScreen
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    // Inicializa a tela de lembretes.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReminderappTheme {
                ReminderScreen(reminderViewModel = koinViewModel())
            }
        }
    }
}
