package com.example.divarsearchfuture.view.search.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.BeyondBoundsLayout
import androidx.compose.ui.modifier.ModifierLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.divarsearchfuture.model.DivarSearchEntity

@Composable
fun DivarSearchItem(
    modifier: Modifier = Modifier,
    divarSearchEntity: DivarSearchEntity
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9F),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        divarSearchEntity.catName, style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold, color = Color(
                                0xFF383838
                            )
                        )
                    )
                    Spacer(modifier.height(8.dp))
                    Text(
                        divarSearchEntity.catTitle,
                        style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
                    )
                }
                Text(divarSearchEntity.postCount, style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray))
            }
            HorizontalDivider()
        }
    }
}