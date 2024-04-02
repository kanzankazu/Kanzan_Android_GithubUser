package com.astro.test.faisalbahri.domain.base

sealed class UiState<out T> {
    object Default : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    object Empty : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}

