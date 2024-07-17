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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.reminderapp.ui.theme.uilayer.screen.ReminderList
import com.example.reminderapp.ui.theme.uilayer.screen.components.showDatePickerDialog
import com.example.reminderapp.viewmodel.ReminderViewModel
import org.koin.androidx.compose.koinViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun ReminderScreen(reminderViewModel: ReminderViewModel = koinViewModel()) {
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
        Text(
            text = "Novo lembrete",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 16.dp)
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
                titleError = title.isEmpty()
            },
            isError = titleError,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "Nome",
                    color = Color.DarkGray,
                )
            }

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
            value = selectedDate?.let { dateFormat.format(it) } ?: "",
            onValueChange = {},
            readOnly = true,
            isError = dateError,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    showDatePickerDialog(context) { date ->
                        reminderViewModel.updateSelectedDate(date)
                        dateError = false
                    }
                },
            label = {
                Text(
                    text = "Data",
                    color = Color.DarkGray,
                )
            }

        )
        if (dateError) {
            Text(
                text = "Data não pode ficar vazia",
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
                    title = ""
                    reminderViewModel.updateSelectedDate(null)
                    Toast.makeText(
                        context,
                        "Lembrete Salvo",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "Por favor, preencha todos os campos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Salvar")
        }
        Spacer(modifier = Modifier.height(16.dp))

        ReminderList(
            reminders = reminderViewModel.reminders.collectAsState(initial = emptyList()).value,
            onDelete = { reminderViewModel.deleteReminder(it) },
        )
    }
}
