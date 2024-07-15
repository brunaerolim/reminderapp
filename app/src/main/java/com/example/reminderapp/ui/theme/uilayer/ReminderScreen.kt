package com.example.reminderapp.ui.theme.uilayer

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.reminderapp.model.Reminder
import com.example.reminderapp.viewmodel.ReminderViewModel
import java.util.Calendar


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReminderScreen(viewModel: ReminderViewModel = hiltViewModel()) {
    val reminders by viewModel.reminders.collectAsState()
    val selectedDate by viewModel.selectedDate.collectAsState()

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            "Novo lembrete",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        AddReminder(viewModel)
        DateSelector(selectedDate) { date -> viewModel.setSelectedDate(date) }
        Text(
            "Lista de lembretes",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        ReminderList(reminders, onDelete = { viewModel.deleteReminder(it) })
    }
}

@Composable
fun DateSelector(selectedDate: String, onDateSelected: (String) -> Unit) {
    val context = LocalContext.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        OutlinedTextField(
            value = selectedDate,
            onValueChange = {},
            label = { Text("Selecionar data") },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = {
                    showDatePicker(context) { date ->
                        onDateSelected(date)
                    }
                }) {
                    Icon(Icons.Default.DateRange, contentDescription = "Select Date")
                }
            },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        )
    }
}

@Composable
fun ReminderList(reminders: List<Reminder>, onDelete: (Reminder) -> Unit) {
    LazyColumn {
        items(reminders) { reminder ->
            ReminderItem(reminder, onDelete)
        }
    }
}

@Composable
fun ReminderItem(reminder: Reminder, onDelete: (Reminder) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = reminder.title,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = { onDelete(reminder) }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete Reminder", tint = Color.Red)
        }
    }
}

@Composable
fun AddReminder(viewModel: ReminderViewModel) {
    var title by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Nome do lembrete") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Data do lembrete (no formato dd/mm/yyyy)") },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = {
                    showDatePicker(context) { selectedDate ->
                        date = selectedDate
                    }
                }) {
                    Icon(Icons.Default.DateRange, contentDescription = "Select Date")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        Button(
            onClick = {
                if (title.isNotEmpty() && date.isNotEmpty()) {
                    val reminder = Reminder(title = title, date = date)
                    viewModel.addReminder(reminder)
                    title = ""
                    date = ""
                }
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(vertical = 8.dp)
        ) {
            Text("Criar")
        }
    }
}

fun showDatePicker(context: Context, onDateSelected: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    DatePickerDialog(context, { _, selectedYear, selectedMonth, selectedDay ->
        val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        onDateSelected(selectedDate)
    }, year, month, day).show()
}