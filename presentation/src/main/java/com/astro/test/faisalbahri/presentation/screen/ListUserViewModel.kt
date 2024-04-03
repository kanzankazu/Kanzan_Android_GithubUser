package com.astro.test.faisalbahri.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astro.test.faisalbahri.common.extensions.onFailure
import com.astro.test.faisalbahri.common.extensions.onSuccess
import com.astro.test.faisalbahri.common.utils.UiState
import com.astro.test.faisalbahri.common.utils.initUiStateDefault
import com.astro.test.faisalbahri.common.utils.initUiStateEmpty
import com.astro.test.faisalbahri.common.utils.initUiStateLoading
import com.astro.test.faisalbahri.common.utils.toUiStateError
import com.astro.test.faisalbahri.common.utils.toUiStateSuccess
import com.astro.test.faisalbahri.domain.model.GithubUsersItem
import com.astro.test.faisalbahri.domain.usecase.UserUseCase
import com.astro.test.faisalbahri.presentation.util.toStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListUserViewModel @Inject constructor(
    private val homeUseCase: UserUseCase,
) : ViewModel() {
    private val _usersList = MutableStateFlow<UiState<List<GithubUsersItem>>>(initUiStateDefault())
    val usersList = _usersList.toStateFlow()
    fun fetchUsers(q: String) {
        if (q.isNotEmpty()) {
            _usersList.value = initUiStateLoading()
            viewModelScope.launch {
                homeUseCase(q)
                    .onSuccess {
                        if (it.items.isNotEmpty()) _usersList.value = it.items.toUiStateSuccess()
                        else _usersList.value = initUiStateEmpty()
                    }
                    .onFailure {
                        _usersList.value = it.toUiStateError()
                    }
            }
        } else {
            _usersList.value = initUiStateDefault()
        }
    }

    fun fetchUsersLoading() {
        _usersList.value = initUiStateLoading()
    }
}
