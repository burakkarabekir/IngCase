package com.burakks.ingcase.di

import com.burakks.ingcase.data.cache.dao.RepoDao
import com.burakks.ingcase.data.cache.model.RepoEntityMapper
import com.burakks.ingcase.data.remote.model.RepoDtoMapper
import com.burakks.ingcase.data.remote.service.RepoService
import com.burakks.ingcase.domain.usecases.FetchRepoUseCase
import com.burakks.ingcase.domain.usecases.FetchReposUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideFetchReposUseCase(
        repoDao: RepoDao,
        repoService: RepoService,
        entityMapper: RepoEntityMapper,
        dtoMapper: RepoDtoMapper
    ): FetchReposUseCase {
        return FetchReposUseCase(
            repoDao= repoDao,
            repoService= repoService,
            entityMapper= entityMapper,
            dtoMapper= dtoMapper
        )
    }

    @ViewModelScoped
    @Provides
    fun provideFetchRepoUseCase(
        repoDao: RepoDao,
        entityMapper: RepoEntityMapper,
    ): FetchRepoUseCase {
        return FetchRepoUseCase(
            repoDao= repoDao,
            entityMapper= entityMapper,
        )
    }
}