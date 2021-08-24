package com.burakks.ingcase.domain.usecases.repo_update

import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.repositories.RepoRepository
import javax.inject.Inject

class UpdateRepoUseCase @Inject constructor(
    private val repository: RepoRepository,
) {
    suspend fun run(
        repo: Repo,
    ) = repository.update(repo)
}
