package com.example.reminderapp.ui.theme.uilayer.screen

import com.example.reminderapp.model.Reminder
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
fun ReminderList(reminders: List<Reminder>, onDelete: (Reminder) -> Unit) {
    LazyColumn {
        reminders.groupBy { reminder ->
            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(reminder.date)
        }.forEach { (date, reminders) ->
            item {
                Text(
                    text = date,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            items(reminders) { reminder ->
                ReminderItem(reminder = reminder, onDelete = onDelete)
            }
        }
    }
}