package com.burakks.ingcase.data.cache.datasource

import com.burakks.ingcase.data.cache.dao.RepoDao
import com.burakks.ingcase.data.cache.model.RepoEntity
import com.burakks.ingcase.data.cache.model.RepoEntityMapper
import com.burakks.ingcase.domain.model.Repo
import javax.inject.Inject

class RepoLocalDataSource @Inject constructor(
    private val repoDao: RepoDao,
    private val entityMapper: RepoEntityMapper,
) {
    suspend fun cacheRepos(repos: List<Repo>) {
        repoDao.deleteAllRepos()
        repoDao.insertRepos(entityMapper.toEntityList(repos))
    }

    suspend fun getAllRepos(): List<RepoEntity> {
        return repoDao.getAllRepos()
    }

    suspend fun getRepoById(repoId: Int): RepoEntity? {
        return repoDao.getRepoById(repoId)
    }

    fun emitFromCache(cacheResult: List<RepoEntity>): List<Repo> {
        return entityMapper.fromEntityList(cacheResult)
    }

    fun emitFromCacheById(repo: RepoEntity): Repo {
        return entityMapper.fromEntity(repo)
    }

}