package com.burakks.ingcase.di

import com.burakks.ingcase.data.cache.dao.RepoDao
import com.burakks.ingcase.data.cache.model.RepoEntityMapper
import com.burakks.ingcase.data.remote.model.RepoDtoMapper
import com.burakks.ingcase.data.remote.service.RepoService
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
        repoDao: RepoDao,
        repoService: RepoService,
        entityMapper: RepoEntityMapper,
        dtoMapper: RepoDtoMapper
    ) : RepoRepository {
        return RepoRepository(
            repoDao= repoDao,
            repoService= repoService,
            entityMapper= entityMapper,
            dtoMapper= dtoMapper
        )
    }
}