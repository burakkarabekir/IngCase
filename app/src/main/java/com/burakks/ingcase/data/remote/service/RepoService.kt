package com.burakks.ingcase.data.remote.service

import com.burakks.ingcase.data.remote.model.RepoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoService {

    @GET(REPOS)
    suspend fun fetchRepos(
        @Path(PATH_USER_NAME) userName: String
    ): List<RepoDto>

    companion object {
        const val PATH_USER_NAME = "user"
        const val REPOS = "users/{$PATH_USER_NAME}/repos"
    }
}