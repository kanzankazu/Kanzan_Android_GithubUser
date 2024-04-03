package com.astro.test.faisalbahri.data.remote.datasource

import com.astro.test.faisalbahri.data.model.GithubUsersSearchResponse
import com.astro.test.faisalbahri.data.remote.Api
import retrofit2.Response
import javax.inject.Inject

internal class UserDataSourceImpl @Inject constructor(
    private val api: Api,
) : UserDataSource {
    override suspend fun getSearchUser(q: String): Response<GithubUsersSearchResponse> {
        return api.getSearchUser(q)
    }
}