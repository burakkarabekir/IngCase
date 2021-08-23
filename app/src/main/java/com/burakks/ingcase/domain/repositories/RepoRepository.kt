package com.burakks.ingcase.domain.repositories

import com.burakks.ingcase.data.cache.dao.RepoDao
import com.burakks.ingcase.data.cache.model.RepoEntityMapper
import com.burakks.ingcase.data.remote.model.RepoDtoMapper
import com.burakks.ingcase.data.remote.service.RepoService
import com.burakks.ingcase.data.cache.datasource.RepoLocalDataSource
import com.burakks.ingcase.data.remote.datasource.RepoRemoteDataSource
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepoRepository @Inject constructor(
    private val localDataSource: RepoLocalDataSource,
    private val remoteDataSource: RepoRemoteDataSource
) {
    fun execute(
        username: String,
    ): Flow<DataState<List<Repo>>> = flow {
        try {
            emit(DataState.loading())

            val repos = remoteDataSource.fetchRepos(username)
            localDataSource.cacheRepos(repos)

            // get results from the cache
            val cacheResult = localDataSource.getAllRepos()

            // emit from cache
            val list = localDataSource.emitFromCache(cacheResult)
            emit(DataState.success(list))
        } catch (e: Exception) {
            emit(DataState.error<List<Repo>>(e.message ?: "Error"))
        }
    }

    fun execute(
        repoId: Int,
    ): Flow<DataState<Repo>> = flow {
        try {
            emit(DataState.loading())

            val repo =localDataSource.getRepoById(repoId)

            // emit from cache
            val list = localDataSource.emitFromCacheById(repo!!)

            emit(DataState.success(list))

        } catch (e: Exception) {
            emit(DataState.error<Repo>(e.message ?: "Error"))
        }
    }
}