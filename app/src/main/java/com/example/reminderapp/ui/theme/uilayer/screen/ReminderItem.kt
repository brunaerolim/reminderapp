package com.example.reminderapp.ui.theme.uilayer.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.reminderapp.model.Reminder
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
fun ReminderItem(reminder: Reminder, onDelete: (Reminder) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = reminder.title,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(reminder.date),
                style = MaterialTheme.typography.bodySmall
            )
        }
        IconButton(
            onClick = { onDelete(reminder) }
        ) {
            Icon(Icons.Default.Delete, contentDescription = "Delete Reminder")
        }
    }
}