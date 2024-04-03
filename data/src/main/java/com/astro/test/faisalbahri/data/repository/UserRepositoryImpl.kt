package com.astro.test.faisalbahri.data.repository

import com.astro.test.faisalbahri.common.utils.Resource
import com.astro.test.faisalbahri.data.extensions.handleAPICall
import com.astro.test.faisalbahri.data.model.GithubUsersSearchResponse
import com.astro.test.faisalbahri.data.remote.datasource.DataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: DataSource
) : UserRepository {
    override suspend fun getSearchUser(q: String): Resource<GithubUsersSearchResponse> {
        return handleAPICall { dataSource.getSearchUser(q) }
    }
}