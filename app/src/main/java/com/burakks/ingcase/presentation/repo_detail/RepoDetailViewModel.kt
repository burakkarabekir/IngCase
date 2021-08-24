package com.burakks.ingcase.presentation.repo_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.usecases.repo_detail.FetchRepoDetailUseCase
import com.burakks.ingcase.domain.usecases.repo_update.UpdateRepoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber.e
import javax.inject.Inject

@HiltViewModel
class RepoDetailViewModel @Inject constructor(
    private val fetchRepoDetailUseCase: FetchRepoDetailUseCase,
    private val updateRepoUseCase: UpdateRepoUseCase,
) : ViewModel() {

    val repo: MutableState<Repo> = mutableStateOf(Repo(1, "", "", false, 2, 1, 1, 1))

    fun getRepo(repoId: Int) {
        viewModelScope.launch {
            fetchRepoDetailUseCase.run(
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

    fun onLikeStatusChanged(repo: Repo) {
        repo.isLiked = !repo.isLiked
        updateRepo(repo)
    }

    private fun updateRepo(repo: Repo) {
        viewModelScope.launch {
            updateRepoUseCase.run(
                repo = repo
            ).launchIn(viewModelScope)
        }
    }
}