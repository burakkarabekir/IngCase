package com.burakks.ingcase.presentation.repo_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Watch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.burakks.ingcase.BuildConfig
import com.burakks.ingcase.R
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.util.DataState
import com.burakks.ingcase.presentation.components.MainTopAppBar
import com.burakks.ingcase.presentation.components.OwnerStatus
import com.burakks.ingcase.ui.theme.SpaceMedium
import com.burakks.ingcase.ui.theme.SpaceSmall
import com.burakks.ingcase.util.Constants.MAX_POST_DESCRIPTION_LINES
import timber.log.Timber.d

const val OWNER_IMAGE_SIZE = 96

@Composable
fun RepoDetailScreen(
    navController: NavHostController,
    repoId: Int? = null,
    viewModel: RepoDetailViewModel = hiltViewModel()
) {
    if (BuildConfig.DEBUG) d("repoId :: ${repoId.toString()}")

    val repoInfo = produceState<DataState<Repo>>(initialValue = DataState.loading()) {
        viewModel.getRepo(repoId!!)
    }.value

    val repo = viewModel.repo.value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        MainTopAppBar(
            navController = navController,
            modifier = Modifier.fillMaxWidth(),
            title = {
                Text(
                    text = repo.name,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground,
                    maxLines = MAX_POST_DESCRIPTION_LINES,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(end = SpaceMedium)
                )
            },
            showBackArrow = true
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SpaceMedium),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                if (repo.id != null) {
                    Image(
                        modifier = Modifier.size(OWNER_IMAGE_SIZE.dp),
                        painter = rememberImagePainter(
                            data = "https://avatars.githubusercontent.com/u/${repo.id}?v=4",
                            builder = {
//                            crossfade(300)
                                transformations(
                                    CircleCropTransformation(),
                                )
                            }
                        ),
                        contentDescription = stringResource(R.string.profile),
                        contentScale = ContentScale.Crop,
                    )
                }

                Text(
                    text = repo.description ?: stringResource(R.string.description),
                    modifier = Modifier
                        .padding(
                            horizontal = SpaceMedium
                        )
                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceSmall),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                OwnerStatus(Icons.Default.Watch, text = stringResource(R.string.watch), number = repo.watchersCount.toString())
                OwnerStatus(Icons.Default.Star, text = stringResource(R.string.star), number = repo.stargazersCount.toString())
                OwnerStatus(Icons.Default.AccountTree, text = stringResource(R.string.fork), number = repo.forksCount.toString())
                OwnerStatus(Icons.Default.Error, text = stringResource(R.string.issues), number = repo.openIssueCount.toString())

            }
        }
    }
}

