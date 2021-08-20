package com.burakks.ingcase.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Repo(
    val id: Int,
    val name: String,
    val url: String,
    val isLiked: Boolean,
    val openIssueCount: Int,
    val stargazersCount: Int,
    val forksCount: Int,
    val watchersCount: Int
) : Parcelable
