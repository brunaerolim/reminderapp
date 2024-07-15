package com.example.reminderapp.ui.theme.uilayer.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReminderDate() {
    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("dd/MM/yyyy")
                .format(pickedDate)
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp, 0.dp, 10.dp, 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Data",
            modifier = Modifier
                .padding(8.dp, 20.dp, 2.dp, 9.dp)
                .background(Color.hsl(0f, 0f, 0.92f))
                .border(1.dp, Color.LightGray)
                .padding(10.dp, 20.dp, 10.dp, 16.dp),
            fontSize = 16.sp,
            style = TextStyle(color = Color.LightGray),
            textAlign = TextAlign.Start
        )
        OutlinedTextField(
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Date",
                    tint = Color.LightGray
                )
            },
            value = "",
            onValueChange = {

            },
            modifier = Modifier
                .clickable {

                }
                .padding(0.dp, 20.dp, 0.dp)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small,
            textStyle = TextStyle(color = Color.LightGray)
        )
        if (openDialog.value) {
            DatePickerDialog(
                colors = DatePickerDefaults.colors(
                    containerColor = Color(0xFFF5F0FF),
                ),
                onDismissRequest = {
                    openDialog.value = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        }
                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        }
                    ) {
                        Text("Cancelar")
                    }
                }
            ) {
                DatePicker(
                    state = datePickerState,
                )
            }
        }
    }
}