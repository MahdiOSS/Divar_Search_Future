package com.example.divarsearchfuture.view.search

import android.util.Log
import android.widget.GridLayout
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.viewModelScope
import com.airbnb.lottie.RenderMode
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.divarsearchfuture.view.search.widget.DivarSearchBoxWidget
import com.example.divarsearchfuture.view.search.widget.DivarSearchItem
import com.example.divarsearchfuture.viewModel.DivarSearchViewModel
import com.example.divarsearchfuture.R
import com.example.divarsearchfuture.model.DivarSearchEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.math.log

@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true, device = "spec:width=1080px,height=2340px,dpi=440")
@Composable
fun SearchScreen(
    viewModel: DivarSearchViewModel = DivarSearchViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    var value by remember { mutableStateOf("") }
    var searchList by remember { mutableStateOf<List<DivarSearchEntity>>(emptyList()) }
    val placeholder by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.search))
    var isPlay by remember { mutableStateOf(false) }
    var isEmptyList by remember { mutableStateOf(false) }


    var visibleItems by remember { mutableStateOf<List<DivarSearchEntity>>(emptyList()) }


    LaunchedEffect(searchList) {
        visibleItems = emptyList()
        searchList.forEachIndexed { index, item ->
            delay(100)
            visibleItems = visibleItems + item
        }
    }

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            DivarSearchBoxWidget(
                value,
                onValueChange = {
                    value = it
                    isPlay = value.isNotEmpty()
                    coroutineScope.launch {
                        var res = viewModel.getSearchList(value)
                        Log.i("Tag", "SearchScreen: Get")
                        isEmptyList = res.isEmpty()


                        searchList = if (res.size >= 5) res.subList(0, 5) else res

                    }
                },
                onClear = {
                    value = ""
                    isEmptyList = false
                    isPlay = false
                },
            )

            if (value.isEmpty())
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    LottieAnimation(
                        modifier = Modifier.size(120.dp),
                        composition = placeholder,
                        isPlaying = isPlay,
                        iterations = LottieConstants.IterateForever
                    )
                }
            else
                if (searchList.isEmpty())
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            LottieAnimation(
                                modifier = Modifier.size(120.dp),
                                composition = placeholder,
                                isPlaying = isPlay,
                                iterations = LottieConstants.IterateForever
                            )
                            if (isEmptyList)
                                Text(
                                    "! چیزی پیدا نکردم",
                                    style = MaterialTheme.typography.bodyLarge.copy(
                                        color = Color.Gray,
                                        fontWeight = FontWeight.W700
                                    )
                                )
                        }
                    }
                else
                    LazyColumn {
                        items(visibleItems) { item ->
                            AnimatedVisibility(
                                visible = true,
                                enter = fadeIn(animationSpec = tween(500)), // انیمیشن fade-in
                                modifier = Modifier.animateItemPlacement(
                                    animationSpec = tween(500) // تنظیم انیمیشن
                                )
                            ) {
                                DivarSearchItem(
                                    divarSearchEntity = item,
                                    modifier = Modifier.animateItemPlacement(
                                        animationSpec = tween(500)
                                    )
                                )
                            }
                        }
                    }

        }
    }
}