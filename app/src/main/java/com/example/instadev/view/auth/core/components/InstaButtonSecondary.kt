package com.example.instadev.view.auth.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable
fun InstaButtonSecondary(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    border: BorderStroke = BorderStroke(1.dp,MaterialTheme.colorScheme.primary),
    title: String="",
    titleColor: Color = MaterialTheme.colorScheme.primary
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        border = border
    ) { InstaText(text = title, color = titleColor) }

}