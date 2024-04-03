package com.astro.test.faisalbahri.domain.usecase

import com.astro.test.faisalbahri.common.utils.Resource
import com.astro.test.faisalbahri.domain.model.GithubUsersSearch

interface UserUseCase {
    suspend operator fun invoke(q: String): Resource<GithubUsersSearch>
}