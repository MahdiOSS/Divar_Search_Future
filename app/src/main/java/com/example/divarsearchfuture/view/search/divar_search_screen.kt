package com.example.divarsearchfuture.view.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.divarsearchfuture.view.search.widget.DivarSearchBoxWidget

@Preview(showSystemUi = true)
@Composable
fun SearchScreen() {
    var value by remember { mutableStateOf("") }
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            DivarSearchBoxWidget(
                value,
                onValueChange = { value = it },
                onClear = { value = "" },
            )
        }
    }
}