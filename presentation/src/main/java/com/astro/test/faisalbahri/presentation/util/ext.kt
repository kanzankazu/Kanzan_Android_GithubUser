package com.astro.test.faisalbahri.presentation.util

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

fun initMod() = Modifier

fun <T> MutableState<T>.toState(): State<T> = this

fun <T> MutableStateFlow<T>.toStateFlow(): StateFlow<T> = this