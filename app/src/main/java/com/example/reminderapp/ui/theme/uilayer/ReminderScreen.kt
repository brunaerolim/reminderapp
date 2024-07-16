package com.example.reminderapp.ui.theme.uilayer

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reminderapp.ui.theme.uilayer.screen.components.showDatePickerDialog
import com.example.reminderapp.viewmodel.ReminderViewModel
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
fun ReminderScreen(reminderViewModel: ReminderViewModel = viewModel()) {
    val context = LocalContext.current
    val selectedDate by reminderViewModel.selectedDate.collectAsState()
    val dateFormat = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }
    var title by remember { mutableStateOf("") }
    var titleError by remember { mutableStateOf(false) }
    var dateError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
                titleError = title.isEmpty()
            },
            label = { Text("Title") },
            isError = titleError,
            modifier = Modifier.fillMaxWidth()
        )
        if (titleError) {
            Text(
                text = "Title cannot be empty",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = if (selectedDate != null) dateFormat.format(selectedDate) else "",
            onValueChange = {},
            label = { Text("Date") },
            readOnly = true,
            isError = dateError,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    showDatePickerDialog(context) { date ->
                        reminderViewModel.updateSelectedDate(date)
                        dateError = false
                    }
                }
        )
        if (dateError) {
            Text(
                text = "Date cannot be empty",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                titleError = title.isEmpty()
                dateError = selectedDate == null

                if (!titleError && !dateError) {
                    reminderViewModel.addReminder(title, selectedDate!!)
                    Toast.makeText(context, "com.example.reminderapp.model.Reminder added", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Add com.example.reminderapp.model.Reminder")
        }
    }
}