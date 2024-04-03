package com.astro.test.faisalbahri.presentation.screen

import androidx.lifecycle.ViewModel
import com.astro.test.faisalbahri.common.utils.Resource
import com.astro.test.faisalbahri.common.utils.UiState
import com.astro.test.faisalbahri.common.utils.initUiStateDefault
import com.astro.test.faisalbahri.common.utils.initUiStateEmpty
import com.astro.test.faisalbahri.common.utils.initUiStateLoading
import com.astro.test.faisalbahri.common.utils.toUiStateError
import com.astro.test.faisalbahri.common.utils.toUiStateSuccess
import com.astro.test.faisalbahri.domain.model.GithubUsersItem
import com.astro.test.faisalbahri.domain.usecase.UserUseCase
import com.astro.test.faisalbahri.presentation.util.getLaunch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ListUserViewModel @Inject constructor(
    private val homeUseCase: UserUseCase,
) : ViewModel() {
    private val _usersList = MutableStateFlow<UiState<List<GithubUsersItem>>>(initUiStateDefault())
    val usersList = _usersList.asStateFlow()
    fun getUsers(q: String) {
        getLaunch {
            if (q.isNotEmpty()) {
                _usersList.emit(initUiStateLoading())
                when (val resource = homeUseCase(q)) {
                    is Resource.Failure -> {
                        _usersList.emit(resource.error.toUiStateError())
                    }

                    is Resource.Success -> {
                        if (resource.data.items.isNotEmpty()) _usersList.emit(resource.data.items.toUiStateSuccess())
                        else _usersList.emit(initUiStateEmpty())
                    }
                }
            } else {
                _usersList.emit(initUiStateDefault())
            }
        }
    }

    fun getUsersLoading() {
        getLaunch {
            _usersList.emit(initUiStateLoading())
        }
    }
}
