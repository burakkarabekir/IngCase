package com.burakks.ingcase.presentation.repo_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.usecases.FetchRepoUseCase
import com.burakks.ingcase.domain.usecases.FetchReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber.e
import javax.inject.Inject

@HiltViewModel
class RepoDetailViewModel @Inject constructor(
    private val fetchRepoUseCase: FetchRepoUseCase,
) : ViewModel() {

    val repo: MutableState<Repo> = mutableStateOf(Repo(1,"","",false,2,1,1,1))

    fun getRepo(repoId: Int) {
        fetchRepoUseCase.execute(
            repoId = repoId
        ).onEach { dataState ->
            dataState.data?.let {
                repo.value = it
            }

            dataState.error?.let { error ->
                e("Error while fetching repos. $error")
            }
        }.launchIn(viewModelScope)
    }
}