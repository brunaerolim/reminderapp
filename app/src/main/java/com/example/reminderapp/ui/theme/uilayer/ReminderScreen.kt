package com.example.reminderapp.ui.theme.uilayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.reminderapp.ui.theme.uilayer.screen.ReminderList
import com.example.reminderapp.viewmodel.ReminderViewModel
import java.util.*

@Composable
fun ReminderScreen(viewModel: ReminderViewModel = hiltViewModel()) {
    val reminders by viewModel.reminders.collectAsState()

    var title by remember { mutableStateOf(TextFieldValue("")) }
    var date by remember { mutableStateOf(Date()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Novo Lembrete", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.surface)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            date = Calendar.getInstance().time
        }) {
            Text("Selecionar Data")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (title.text.isNotEmpty()) {
                viewModel.addReminder(title.text, date)
                title = TextFieldValue("")
            }
        }) {
            Text("Criar")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text("Lista de Lembretes", style = MaterialTheme.typography.titleMedium)
        ReminderList(reminders = reminders, onDelete = viewModel::deleteReminder)
    }
}
