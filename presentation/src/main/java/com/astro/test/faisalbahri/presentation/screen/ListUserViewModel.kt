package com.astro.test.faisalbahri.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astro.test.faisalbahri.domain.base.UiState
import com.astro.test.faisalbahri.domain.base.initUiStateDefault
import com.astro.test.faisalbahri.domain.base.initUiStateLoading
import com.astro.test.faisalbahri.domain.base.toUiStateError
import com.astro.test.faisalbahri.domain.base.toUiStateSuccess
import com.astro.test.faisalbahri.presentation.util.toStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListUserViewModel @Inject constructor() : ViewModel() {
    private val _users = MutableStateFlow<UiState<List<String>>>(initUiStateDefault())
    val users = _users.toStateFlow()

    fun fetchUsers() {
        _users.value = initUiStateLoading()
        viewModelScope.launch {
            try {
                delay(2000) // Simulating network delay
                _users.value = listOf("qwe", "asd", "zxc", "rty", "fgh", "vbn", "asd", "zxc", "rty", "fgh", "vbn", "asd", "zxc", "rty", "fgh", "vbn").toUiStateSuccess()
            } catch (e: Exception) {
                _users.value = "Error fetching data".toUiStateError()
            }
        }
    }

    init {
        fetchUsers()
    }
}
