package com.astro.test.faisalbahri.data.datasource

import com.astro.test.faisalbahri.data.model.GithubUsersSearchResponse
import com.astro.test.faisalbahri.data.remote.Api
import com.astro.test.faisalbahri.data.remote.datasource.UserDataSourceImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class UserDataSourceTest {

    private val api = mockk<Api>()

    private lateinit var dataSource: UserDataSourceImpl

    @Before
    fun setUp() {
        dataSource = UserDataSourceImpl(api)
    }

    @Test
    fun `getSearchUser returns expected response`() = runTest {
        val expectedResponse = mockk<Response<GithubUsersSearchResponse>>()
        val queryRequest = "Kanzan"
        coEvery { api.getSearchUser(queryRequest) } returns expectedResponse

        val result = dataSource.getSearchUser(queryRequest)

        assertEquals(expectedResponse, result)
    }
}