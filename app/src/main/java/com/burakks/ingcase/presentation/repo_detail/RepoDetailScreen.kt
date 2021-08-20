package com.burakks.ingcase.presentation.repo_detail

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.burakks.ingcase.R
import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.domain.util.DataState
import com.burakks.ingcase.presentation.components.MainTopAppBar
import com.burakks.ingcase.ui.theme.ElevationSmall
import com.burakks.ingcase.ui.theme.RadiusMedium
import com.burakks.ingcase.ui.theme.SpaceMedium
import com.burakks.ingcase.ui.theme.SpaceSmall
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
                horizontalArrangement = Arrangement.SpaceBetween,
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceSmall),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                OwnerStatus(Icons.Default.Watch,text = stringResource(R.string.watch), number = repo.watchersCount.toString())
                OwnerStatus(Icons.Default.Star,text = stringResource(R.string.star), number = repo.stargazersCount.toString())
                OwnerStatus(Icons.Default.AccountTree,text = stringResource(R.string.fork), number = repo.forksCount.toString())
                OwnerStatus(Icons.Default.Error,text = stringResource(R.string.issues), number = repo.openIssueCount.toString())

            }
        }
    }
}

@Composable
fun OwnerStatus(
    icon: ImageVector,
    text: String,
    number: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(RadiusMedium),
        modifier = modifier
            .wrapContentWidth()
            .background(Color.White)
            .padding(SpaceMedium),
        elevation = ElevationSmall
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .background(Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = modifier
                    .weight(5f)
                    .background(Color(0xFFF3F4F6))
            ) {
                Icon(
                    icon,
                    contentDescription = stringResource(id = R.string.watch),
                )
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .background(Color(0xFFF3F4F6))
                        .padding(SpaceSmall),
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 24.sp
                    ),
                )
            }
            Text(
                text = number,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 24.sp
                ),
                modifier = modifier
                    .padding(SpaceSmall)
                    .weight(5f),
            )
        }
    }

}