package com.astro.test.faisalbahri.data.mapper

import com.astro.test.faisalbahri.common.extensions.DataToDomainModelMapper
import com.astro.test.faisalbahri.common.extensions.orNull
import com.astro.test.faisalbahri.common.extensions.orNullListNotNot
import com.astro.test.faisalbahri.data.model.GithubUsersSearchResponse
import com.astro.test.faisalbahri.domain.model.GithubUsersItem
import com.astro.test.faisalbahri.domain.model.GithubUsersSearch
import javax.inject.Inject

class GithubUsersSearchDomainModelMapper @Inject constructor() :
    DataToDomainModelMapper<GithubUsersSearchResponse, GithubUsersSearch> {
    override fun mapToDomainModel(responseModel: GithubUsersSearchResponse): GithubUsersSearch = with(responseModel) {
        GithubUsersSearch(
            incompleteResults = incompleteResults.orNull(),
            items = items.orNullListNotNot(GithubUsersItem()) {
                GithubUsersItem(
                    avatarUrl = avatarUrl.orNull(),
                    eventsUrl = eventsUrl.orNull(),
                    followersUrl = followersUrl.orNull(),
                    followingUrl = followingUrl.orNull(),
                    gistsUrl = gistsUrl.orNull(),
                    gravatarId = gravatarId.orNull(),
                    htmlUrl = htmlUrl.orNull(),
                    id = id.orNull(),
                    login = login.orNull(),
                    nodeId = nodeId.orNull(),
                    organizationsUrl = organizationsUrl.orNull(),
                    receivedEventsUrl = receivedEventsUrl.orNull(),
                    reposUrl = reposUrl.orNull(),
                    score = score.orNull(),
                    siteAdmin = siteAdmin.orNull(),
                    starredUrl = starredUrl.orNull(),
                    subscriptionsUrl = subscriptionsUrl.orNull(),
                    type = type.orNull(),
                    url = url.orNull()
                )
            },
            totalCount = totalCount.orNull()
        )
    }
}
