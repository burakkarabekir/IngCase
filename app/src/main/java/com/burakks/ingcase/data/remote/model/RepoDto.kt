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

    @SerializedName("private")
    val `private`: Boolean,

    @SerializedName("stargazers_count")
    val stargazersCount: Int,

    @SerializedName("watchers_count")
    val watchersCount: Int,

    @SerializedName("forks_count")
    val forksCount: Int,

    @SerializedName("description")
    val description: String,
)