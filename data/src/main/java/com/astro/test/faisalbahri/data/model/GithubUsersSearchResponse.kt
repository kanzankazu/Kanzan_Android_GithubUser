package com.astro.test.faisalbahri.data.model


import com.astro.test.faisalbahri.common.model.ResponseModel
import com.google.gson.annotations.SerializedName

data class GithubUsersSearchResponse(
    @SerializedName("incomplete_results") var incompleteResults: Boolean? = null,
    @SerializedName("items") var items: List<GithubUsersItemResponse?>? = null,
    @SerializedName("total_count") var totalCount: Int? = null,
) : ResponseModel