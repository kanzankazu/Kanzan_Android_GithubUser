package com.astro.test.faisalbahri.data.repository

import com.astro.test.faisalbahri.common.utils.Resource
import com.astro.test.faisalbahri.data.model.GithubUsersSearchResponse
import com.astro.test.faisalbahri.data.remote.datasource.UserDataSource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class UserRepositoryTest {

    private val userDataSource = mockk<UserDataSource>()
    private lateinit var userRepository: UserRepository

    private val githubUsersSearchResponse = GithubUsersSearchResponse(
        incompleteResults = null,
        items = listOf(),
        totalCount = null
    )

    @Before
    fun setUp() {
        userRepository = UserRepositoryImpl(userDataSource)
    }

    @Test
    fun `getListFirst returns success`() = runBlocking {
        val mockResponse = mockk<Response<GithubUsersSearchResponse>>()
        val searchUserParam = "Kanzan"
        val searchUserParamSlot = slot<String>()
        every { mockResponse.isSuccessful } returns true
        every { mockResponse.body() } returns githubUsersSearchResponse

        val expectedResource = Resource.Success(githubUsersSearchResponse)
        coEvery { userDataSource.getSearchUser(capture(searchUserParamSlot)) } returns mockResponse

        val result = userRepository.getSearchUser(searchUserParam)

        assertEquals(searchUserParam, searchUserParamSlot.captured)
        assertEquals(expectedResource, result)
        coVerify(exactly = 1) { userDataSource.getSearchUser(searchUserParam) }
    }
}