package com.burakks.ingcase.domain.repositories

import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.util.DataState
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun execute(username: String): Flow<DataState<List<Repo>>>
    suspend fun execute(repoId: Int): Flow<DataState<Repo>>
    suspend fun update(repo: Repo): Flow<DataState<Repo>>
}