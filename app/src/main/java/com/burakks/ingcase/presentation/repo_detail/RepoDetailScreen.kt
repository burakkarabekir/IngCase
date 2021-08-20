package com.burakks.ingcase.presentation.repo_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.burakks.ingcase.R
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.util.DataState
import com.burakks.ingcase.presentation.components.MainTopAppBar
import com.burakks.ingcase.ui.theme.*
import timber.log.Timber.d

const val OWNER_IMAGE_SIZE = 96

@Composable
fun RepoDetailScreen(
    navController: NavHostController,
    repoId: Int? = null,
    viewModel: RepoDetailViewModel = hiltViewModel()
) {
    d("repoId :: ${repoId.toString()}")

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
                    text = repo.name ?: "Repo Detail Page",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
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
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (repo.id != null) {

                    Image(
                        modifier = Modifier.size(OWNER_IMAGE_SIZE.dp),
                        painter = rememberImagePainter(
                            data = "https://avatars.githubusercontent.com/u/23719655?v=4",
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
                Text(text = repo.name ?: "Repo Detail Page")
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceSmall),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                OwnerStatus(text = stringResource(R.string.star), number = repo.stargazersCount.toString())
                OwnerStatus(text = stringResource(R.string.issues), number = repo.openIssueCount.toString())
                OwnerStatus(text = stringResource(R.string.star), number = repo.stargazersCount.toString())
                OwnerStatus(text = stringResource(R.string.issues), number = repo.openIssueCount.toString())

            }
        }
    }
}

@Composable
fun OwnerStatus(
    text: String,
    number: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(RadiusMedium),
        modifier = modifier
            .wrapContentWidth()
            .background(Color.White),
        elevation = ElevationSmall
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .background(Color.White)
        ) {
            Text(
                text = text,
                modifier = modifier
                    .background(Color(0xFFF3F4F6))
                    .padding(SpaceSmall),
                )
            Text(
                text = number,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(SpaceSmall),
                )
        }
    }

}