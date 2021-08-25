package com.burakks.ingcase.domain.repositories

import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.util.DataState
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    fun execute(username: String): Flow<DataState<List<Repo>>>
    fun execute(repoId: Int): Flow<DataState<Repo>>
    fun update(repo: Repo): Flow<DataState<Repo>>
}