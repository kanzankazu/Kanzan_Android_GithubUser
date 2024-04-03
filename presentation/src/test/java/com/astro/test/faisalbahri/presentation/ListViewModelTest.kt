package com.astro.test.faisalbahri.presentation

import com.astro.test.faisalbahri.common.utils.MainDispatcherRule
import com.astro.test.faisalbahri.common.utils.Resource
import com.astro.test.faisalbahri.common.utils.UiState
import com.astro.test.faisalbahri.common.utils.initUiStateDefault
import com.astro.test.faisalbahri.domain.model.GithubUsersItem
import com.astro.test.faisalbahri.domain.model.GithubUsersSearch
import com.astro.test.faisalbahri.domain.usecase.UserUseCase
import com.astro.test.faisalbahri.presentation.screen.ListUserViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ListViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule(testDispatcher)

    private val userUseCase = mockk<UserUseCase>()

    private lateinit var viewModel: ListUserViewModel

    @Before
    fun setUp() {
        viewModel = ListUserViewModel(userUseCase)
    }

    @Test
    fun `getList emits success event`() = runTest {
        val githubUsersSearch = GithubUsersSearch(items = listOf(GithubUsersItem()))
        val mockRequest = "kanzan"
        coEvery { userUseCase(mockRequest) } returns Resource.Success(githubUsersSearch)

        val events = MutableStateFlow<UiState<List<GithubUsersItem>>>(initUiStateDefault())
        val job = launch {
            viewModel.usersList.collect { events.emit(it) }
        }

        viewModel.getUsers(mockRequest)
        advanceUntilIdle()

        assertTrue(events.value is UiState.Success)

        job.cancel()
    }

    @Test
    fun `getList emits empty event`() = runTest {
        val githubUsersSearch = GithubUsersSearch()
        val mockRequest = "kanzan"
        coEvery { userUseCase(mockRequest) } returns Resource.Success(githubUsersSearch)

        val events = MutableStateFlow<UiState<List<GithubUsersItem>>>(initUiStateDefault())
        val job = launch {
            viewModel.usersList.collect { events.emit(it) }
        }

        viewModel.getUsers(mockRequest)
        advanceUntilIdle()

        assertTrue(events.value is UiState.Empty)

        job.cancel()
    }


    @Test
    fun `getList emits failure event`() = runTest {
        val errorMessage = "Network error"
        val mockRequest = "kanzan"
        coEvery { userUseCase(mockRequest) } returns Resource.Failure(errorMessage)

        val events = MutableStateFlow<UiState<List<GithubUsersItem>>>(initUiStateDefault())
        val job = launch {
            viewModel.usersList.collect { events.emit(it) }
        }

        viewModel.getUsers(mockRequest)
        advanceUntilIdle()

        assertTrue(events.value is UiState.Error)

        job.cancel()
    }
}