package com.burakks.ingcase.data.remote.model


import com.google.gson.annotations.SerializedName

data class RepoDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("open_issues_count")
    val openIssuesCount: Int,

    @SerializedName("owner")
    val owner: Owner,

    @SerializedName("private")
    val `private`: Boolean,

    @SerializedName("pushed_at")
    val pushedAt: String,

    @SerializedName("stargazers_count")
    val stargazersCount: Int,

    @SerializedName("watchers_count")
    val watchersCount: Int,

    @SerializedName("forks_count")
    val forksCount: Int,

    val isLiked: Boolean = false,

    @SerializedName("description")
    val description: String,
)