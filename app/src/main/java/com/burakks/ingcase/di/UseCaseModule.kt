package com.burakks.ingcase.di

import com.burakks.ingcase.data.cache.dao.RepoDao
import com.burakks.ingcase.data.cache.model.RepoEntityMapper
import com.burakks.ingcase.data.remote.model.RepoDtoMapper
import com.burakks.ingcase.data.remote.service.RepoService
import com.burakks.ingcase.domain.repositories.RepoRepository
import com.burakks.ingcase.domain.usecases.repo_detail.FetchRepoDetailUseCase
import com.burakks.ingcase.domain.usecases.repo_list.FetchReposUseCase
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
        repository: RepoRepository,
    ): FetchReposUseCase {
        return FetchReposUseCase(
           repository = repository
        )
    }

    @ViewModelScoped
    @Provides
    fun provideFetchRepoDetailUseCase(
        repository: RepoRepository
    ): FetchRepoDetailUseCase {
        return FetchRepoDetailUseCase(
           repository = repository
        )
    }
}