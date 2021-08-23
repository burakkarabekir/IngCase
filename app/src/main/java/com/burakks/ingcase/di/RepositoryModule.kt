package com.burakks.ingcase.di

import com.burakks.ingcase.data.cache.dao.RepoDao
import com.burakks.ingcase.data.cache.model.RepoEntityMapper
import com.burakks.ingcase.data.remote.model.RepoDtoMapper
import com.burakks.ingcase.data.remote.service.RepoService
import com.burakks.ingcase.data.cache.datasource.RepoLocalDataSource
import com.burakks.ingcase.data.remote.datasource.RepoRemoteDataSource
import com.burakks.ingcase.domain.repositories.RepoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepoRepository(
        localDataSource: RepoLocalDataSource,
        remoteDataSource: RepoRemoteDataSource
    ) : RepoRepository {
        return RepoRepository(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )
    }

    @Singleton
    @Provides
    fun provideRepoLocalDataSource(
        repoDao: RepoDao,
        entityMapper: RepoEntityMapper,
    ): RepoLocalDataSource {
        return RepoLocalDataSource(
            repoDao = repoDao,
            entityMapper = entityMapper
        )
    }

    @Singleton
    @Provides
    fun provideRepoRemoteDataSource(
        repoService: RepoService,
        dtoMapper: RepoDtoMapper
    ): RepoRemoteDataSource {
        return RepoRemoteDataSource(
            repoService = repoService,
            dtoMapper = dtoMapper
        )
    }
}