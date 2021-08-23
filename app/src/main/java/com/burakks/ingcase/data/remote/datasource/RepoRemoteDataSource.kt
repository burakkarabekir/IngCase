package com.burakks.ingcase.data.remote.datasource

import com.burakks.ingcase.data.remote.model.RepoDtoMapper
import com.burakks.ingcase.data.remote.service.RepoService
import com.burakks.ingcase.domain.model.Repo
import javax.inject.Inject

class RepoRemoteDataSource @Inject constructor(
    private val repoService: RepoService,
    private val dtoMapper: RepoDtoMapper
) {
    suspend fun fetchRepos(username: String): List<Repo> {
        return dtoMapper.toDomainList(
            repoService.fetchRepos(username)
        )
    }

}