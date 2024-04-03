package com.astro.test.faisalbahri.data.remote.datasource

import com.astro.test.faisalbahri.data.model.GithubUsersSearchResponse
import retrofit2.Response

interface UserDataSource {
    suspend fun getSearchUser(q: String): Response<GithubUsersSearchResponse>
}