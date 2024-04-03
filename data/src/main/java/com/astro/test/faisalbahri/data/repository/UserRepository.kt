package com.astro.test.faisalbahri.data.repository

import com.astro.test.faisalbahri.common.utils.Resource
import com.astro.test.faisalbahri.data.model.GithubUsersSearchResponse

interface UserRepository {
    suspend fun getSearchUser(q: String): Resource<GithubUsersSearchResponse>
}