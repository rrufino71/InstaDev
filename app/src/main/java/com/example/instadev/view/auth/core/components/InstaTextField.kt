package com.example.instadev.view.auth.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.example.instadev.R

@Composable
fun InstaTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier:Modifier=Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    label: String = ""
) {
    OutlinedTextField(
        modifier = modifier,
        shape = shape,
        value = value,
        label = {
            InstaText(
                text = label,
            )
        },
        onValueChange = { onValueChange(it) })
}