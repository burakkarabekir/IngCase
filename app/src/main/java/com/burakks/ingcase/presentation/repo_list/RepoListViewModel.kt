package com.burakks.ingcase.presentation.repo_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.usecases.repo_list.FetchReposUseCase
import com.burakks.ingcase.util.network.ConnectionType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber.e
import timber.log.Timber.i
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val network: StateFlow<ConnectionType>,
    private val fetchReposUseCase: FetchReposUseCase,
) : ViewModel() {
    val repos: MutableState<List<Repo>> = mutableStateOf(listOf())
    val query = mutableStateOf("")
    val isConnected = mutableStateOf(true)
    // val isQueryValid = mutableStateOf(true)
    val isLiked = mutableStateOf(false)
    val isLoading = mutableStateOf(false)

    fun fetchRepos(_query: String?) {
        val query = _query?.trim() ?: return
        if (query.length <= MIN_SEARCHABLE_LENGTH) return

        viewModelScope.launch {
            network
                .onEach {
                    when (it) {
                        is ConnectionType.Available -> {
                            i("Connection type Available")
                            isConnected.value = true
                            fetchReposUseCase.run(
                                username = query
                            ).onEach { dataState ->
                                isLoading.value = dataState.loading
                                dataState.data?.let { list ->
                                    repos.value = list
                                }

                                dataState.error?.let { error ->
                                    e("Error while fetching repos. $error")
                                }
                            }.launchIn(this)
                        }
                        is ConnectionType.Lost -> {
                            i("Connection type lost")
                            isConnected.value = false
                        }
                        else -> {
                            i("Connection type Init")
                        }
                    }
                }
                .catch { }
                .launchIn(this)
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query

    }

    fun onLikeStatusChanged(isLiked: Boolean) {
        this.isLiked.value = isLiked

    }

    fun updateRepo(repo: Repo) {

    }

    companion object {
        private const val MIN_SEARCHABLE_LENGTH = 2
    }
}