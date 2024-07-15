package com.example.reminderapp.ui.theme.uilayer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun ListSection() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
    ) { // Add LazyColumn
        items(6) { _ ->
            Text(
                modifier = Modifier
                    .padding(10.dp, 0.dp, 0.dp, 10.dp), text = "Lembrete exemplo"
            )
            Text(
                modifier = Modifier
                    .padding(20.dp, 0.dp, 0.dp, 10.dp),
                text = "Data exemplo"
            )
            IconButton(
                onClick = {

                },
                modifier = Modifier.padding(6.dp, 0.dp, 10.dp, 10.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .size(18.dp),
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Reminder",
                    tint = colorResource(id = android.R.color.holo_red_dark)
                )

            }

        }
    }
}
