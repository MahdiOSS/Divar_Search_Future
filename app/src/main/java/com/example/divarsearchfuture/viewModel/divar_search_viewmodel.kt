package com.example.divarsearchfuture.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.divarsearchfuture.model.DivarSearchEntity
import com.example.divarsearchfuture.model.generateSearchList
import kotlinx.coroutines.delay
import kotlin.random.Random

class DivarSearchViewModel : ViewModel() {
    private var _searchList = mutableStateListOf<DivarSearchEntity>()
        get() = generateSearchList().toMutableStateList()
    val searchList: List<DivarSearchEntity> = _searchList

    suspend fun getSearchList(search: String): List<DivarSearchEntity> {
        var list = listOf<DivarSearchEntity>().toMutableList()
        for (item in _searchList) {
            if (item.catName.contains(search)) {
                list.add(item)
            }
        }
        delay(1500)
        Log.i("TAG", "getSearchList: ${Random(2000).nextLong(1500)}")
        return list
    }

}