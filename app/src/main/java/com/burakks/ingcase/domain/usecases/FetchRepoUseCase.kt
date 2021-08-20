package com.burakks.ingcase.domain.usecases

import com.burakks.ingcase.data.cache.dao.RepoDao
import com.burakks.ingcase.data.cache.model.RepoEntityMapper
import com.burakks.ingcase.data.remote.model.RepoDtoMapper
import com.burakks.ingcase.data.remote.service.RepoService
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FetchRepoUseCase(
    private val repoDao: RepoDao,
    private val entityMapper: RepoEntityMapper,
) {
    fun execute(
        repoId: Int,
    ): Flow<DataState<Repo>> = flow {
        try {
            emit(DataState.loading())

            val repo =repoDao.getRepoById(repoId)

            // emit from cache
            val list = entityMapper.fromEntity(repo!!)

            emit(DataState.success(list))

        } catch (e: Exception) {
            emit(DataState.error<Repo>(e.message ?: "Error"))
        }
    }
}