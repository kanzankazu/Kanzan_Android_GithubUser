package com.astro.test.faisalbahri.domain.model


import com.astro.test.faisalbahri.common.model.DomainModel

data class GithubUsersSearch(
    var incompleteResults: Boolean = false,
    var items: List<GithubUsersItem> = emptyList(),
    var totalCount: Int = 0,
) : DomainModel