package com.burakks.ingcase.domain.usecases.repo_detail

import com.burakks.ingcase.data.cache.dao.RepoDao
import com.burakks.ingcase.data.cache.model.RepoEntityMapper
import com.burakks.ingcase.data.remote.model.RepoDtoMapper
import com.burakks.ingcase.data.remote.service.RepoService
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.repositories.RepoRepository
import com.burakks.ingcase.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchRepoDetailUseCase @Inject constructor(
    private val repository: RepoRepository,
) {
    suspend fun run(
        repoId: Int,
    ) = repository.execute(repoId)
}