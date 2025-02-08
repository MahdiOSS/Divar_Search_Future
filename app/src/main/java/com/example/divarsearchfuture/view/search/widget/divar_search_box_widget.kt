package com.example.divarsearchfuture.view.search.widget

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha

@Composable
fun DivarSearchBoxWidget(
    value: String,
    onValueChange: (String) -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier
) {
    val animate by animateFloatAsState(targetValue = if(value.isEmpty()) 0F else 1F, label = "")
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp)
                .shadow(8.dp)
                .background(color = Color(0xFFf4f4f4))
        ) {
            IconButton(onClick = {}) {
                Icon(
                    contentDescription = null,
                    tint = Color(0xFF6a6a6a),
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack
                )
            }
            OutlinedTextField(
                value = value,
                placeholder = {
                    Text(
                        "جستجو",
                        style = MaterialTheme.typography.bodyLarge.copy(color = Color(0xffa5a4a9))
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = Color(0xffaf3636)
                ),
                onValueChange = onValueChange,
            )

            IconButton(onClick = onClear, modifier = Modifier.alpha(animate)) {
                Icon(
                    contentDescription = null,
                    imageVector = Icons.Rounded.Clear,
                    tint = Color(0xFF6a6a6a),
                    modifier = Modifier
                        .size(24.dp)
                        .border(1.dp, color = Color(0xFF6a6a6a), CircleShape)
                        .padding(4.dp)
                )
            }
        }
    }
}