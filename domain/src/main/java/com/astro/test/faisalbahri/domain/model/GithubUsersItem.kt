package com.astro.test.faisalbahri.domain.model

import com.astro.test.faisalbahri.common.model.DomainModel

data class GithubUsersItem(
    var avatarUrl: String = "",
    var eventsUrl: String = "",
    var followersUrl: String = "",
    var followingUrl: String = "",
    var gistsUrl: String = "",
    var gravatarId: String = "",
    var htmlUrl: String = "",
    var id: Int = 0,
    var login: String = "",
    var nodeId: String = "",
    var organizationsUrl: String = "",
    var receivedEventsUrl: String = "",
    var reposUrl: String = "",
    var score: Double = 0.0,
    var siteAdmin: Boolean = false,
    var starredUrl: String = "",
    var subscriptionsUrl: String = "",
    var type: String = "",
    var url: String = "",
) : DomainModel
