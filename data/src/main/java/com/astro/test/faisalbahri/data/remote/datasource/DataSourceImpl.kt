package com.astro.test.faisalbahri.data.remote.datasource

import com.astro.test.faisalbahri.data.model.GithubUsersSearchResponse
import com.astro.test.faisalbahri.data.remote.Api
import retrofit2.Response
import javax.inject.Inject

internal class DataSourceImpl @Inject constructor(
    private val api: Api,
) : DataSource{
    override suspend fun getSearchUser(q: String): Response<GithubUsersSearchResponse> {
        return api.getSearchUser(q)
    }
}