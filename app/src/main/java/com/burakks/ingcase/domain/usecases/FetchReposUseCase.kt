package com.burakks.ingcase.domain.usecases

import com.burakks.ingcase.data.cache.dao.RepoDao
import com.burakks.ingcase.data.cache.model.RepoEntityMapper
import com.burakks.ingcase.data.remote.model.RepoDtoMapper
import com.burakks.ingcase.data.remote.service.RepoService
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FetchReposUseCase(
    private val repoDao: RepoDao,
    private val repoService: RepoService,
    private val entityMapper: RepoEntityMapper,
    private val dtoMapper: RepoDtoMapper
) {
    fun execute(
        username: String,
        isNetworkAvailable: Boolean = true // check internet connection
    ): Flow<DataState<List<Repo>>> = flow {
        try {
            emit(DataState.loading())

            if (isNetworkAvailable) {
                val repos = fetchRepos(username)
                repoDao.insertRepos(entityMapper.toEntityList(repos))
            }

            // get results from the cache
            val cacheResult = repoDao.getAllRepos()
            // TODO: 19.08.2021  val cacheResult = repoDao.getById()

            // emit from cache
            val list = entityMapper.fromEntityList(cacheResult)

            emit(DataState.success(list))

        } catch (e: Exception) {
            emit(DataState.error<List<Repo>>(e.message ?: "Error"))
        }
    }

    private suspend fun fetchRepos(username: String): List<Repo> {
        return dtoMapper.toDomainList(
            repoService.fetchRepos(username)
        )
    }
}