package com.burakks.ingcase.data.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos")
data class RepoEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "is_liked")
    val isLiked: Boolean,

    @ColumnInfo(name = "open_issues_count")
    val openIssuesCount: Int,

    @ColumnInfo(name = "stargazers_count")
    val stargazersCount: Int,

    @ColumnInfo(name = "watchers_count")
    val watchersCount: Int,

    @ColumnInfo(name = "forks_count")
    val forksCount: Int,

    @ColumnInfo(name = "description")
    val description: String,
)