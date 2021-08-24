package com.burakks.ingcase.domain.usecases.repo_detail

import com.burakks.ingcase.domain.repositories.RepoRepository
import javax.inject.Inject

class FetchRepoDetailUseCase @Inject constructor(
    private val repository: RepoRepository,
) {
    suspend fun run(
        repoId: Int,
    ) = repository.execute(repoId)
}