package com.burakks.ingcase.presentation.repo_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.usecases.FetchReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber.e
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val useCase: FetchReposUseCase
): ViewModel() {
    val repos: MutableState<List<Repo>> = mutableStateOf(listOf())
    val query = mutableStateOf("")

    fun fetchRepos(_query: String?) {
        val query = _query?.trim() ?: return
        if (query.length <= MIN_SEARCHABLE_LENGTH) return
            useCase.execute(
                username = query
            ).onEach { dataState ->
                dataState.data?.let { list ->
                    repos.value = list
                }

                dataState.error?.let { error ->
                    e("Error while fetching repos. $error")
                }
            }.launchIn(viewModelScope)
    }

    fun onQueryChanged(query: String){
        this.query.value = query

    }

    companion object {
        private const val MIN_SEARCHABLE_LENGTH = 2
    }
}