package com.burakks.ingcase.domain.usecases.repo_list

import com.burakks.ingcase.domain.repositories.RepoRepository
import javax.inject.Inject

class FetchReposUseCase @Inject constructor(
    private val repository: RepoRepository,
) {
    suspend fun run(
        username: String,
    ) = repository.execute(username)
}