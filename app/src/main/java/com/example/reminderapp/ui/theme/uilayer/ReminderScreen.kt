package com.example.reminderapp.ui.theme.uilayer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reminderapp.ui.theme.uilayer.components.PrimaryButton
import com.example.reminderapp.ui.theme.uilayer.components.ReminderDate


@Composable
fun ReminderScreen(
) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {

            ReminderTitle()
            ReminderDate()
            SaveButton()
            ListText()
            ListSection()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderTitle() {

    Row(
        modifier = Modifier
            .padding(6.dp, 0.dp, 10.dp, 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Nome",
            modifier = Modifier
                .padding(8.dp, 20.dp, 0.dp, 10.dp)
                .background(Color.hsl(0f, 0f, 0.92f))
                .border(1.dp, Color.LightGray)
                .padding(10.dp, 20.dp, 9.dp, 16.dp),
            fontSize = 15.sp,
            style = TextStyle(color = Color.LightGray),
            textAlign = TextAlign.Start
        )
        OutlinedTextField(
            value = "",
            onValueChange = {

            },
            modifier = Modifier
                .padding(0.dp, 12.dp, 12.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.LightGray),
            shape = MaterialTheme.shapes.small,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Title",
                    tint = Color.LightGray
                )
            }

        )
    }
}

@Composable
fun SaveButton(
) {
    PrimaryButton(
        onClick = {},
        title = "Salvar",
    )
}

@Composable
fun ListText() {
    Text(
        text = "Lista de Lembretes",
        modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 10.dp),
        fontSize = 20.sp
    )
}
