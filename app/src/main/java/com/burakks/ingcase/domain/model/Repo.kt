package com.burakks.ingcase.domain.model

data class Repo(
    val id: Int,
    val name: String,
    val url: String,
    var isLiked: Boolean,
    val openIssueCount: Int,
    val stargazersCount: Int,
    val forksCount: Int,
    val watchersCount: Int,
    val description: String? = null,
    val avatar: String = "https://avatars.githubusercontent.com/u/${id}?v=4"
)
