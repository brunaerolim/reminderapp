package com.example.reminderapp.ui.theme.uilayer.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    title: String
) {
    Button(
        onClick = onClick,
    ) {
        Text(title)
    }
}