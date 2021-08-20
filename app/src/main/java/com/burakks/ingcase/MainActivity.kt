package com.burakks.ingcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.remember
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.presentation.navigation.Screen
import com.burakks.ingcase.presentation.repo_detail.RepoDetailScreen
import com.burakks.ingcase.presentation.repo_list.RepoListScreen
import com.burakks.ingcase.presentation.repo_list.RepoListViewModel
import com.burakks.ingcase.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    @ExperimentalCoroutinesApi
    @ExperimentalFoundationApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()

                        NavHost(
                            navController = navController,
                            startDestination = Screen.RepoListScreen.route,
                            builder = {
                                composable(
                                    Screen.RepoListScreen.route
                                ) {
                                    RepoListScreen(
                                        navController = navController,
                                    )
                                }
                                composable(
                                    "repo_detail_screen/{repoId}",
                                    arguments = listOf(
                                        navArgument("repoId") {
                                            type = NavType.IntType
                                        }
                                    )
                                ) { entry ->
                                    RepoDetailScreen(
                                        navController = navController,
                                        entry.arguments?.getInt("repoId")
                                    )
                                }
                            }
                        )
                    
                }
            }
        }
    }
}