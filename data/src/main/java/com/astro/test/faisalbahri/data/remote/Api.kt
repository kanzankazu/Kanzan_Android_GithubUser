package com.astro.test.faisalbahri.data.remote

import com.astro.test.faisalbahri.data.model.GithubUsersSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    suspend fun getSearchUser(
        @Query("q") q: String,
    ): Response<GithubUsersSearchResponse>
}