package com.astro.test.faisalbahri.presentation.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.astro.test.faisalbahri.common.utils.UiState
import com.astro.test.faisalbahri.common.utils.initUiStateEmpty
import com.astro.test.faisalbahri.common.utils.initUiStateLoading
import com.astro.test.faisalbahri.common.utils.toUiStateSuccess
import com.astro.test.faisalbahri.domain.model.GithubUsersItem
import com.astro.test.faisalbahri.presentation.component.DotsCollision
import com.astro.test.faisalbahri.presentation.ui.theme.nunitoFamily
import com.astro.test.faisalbahri.presentation.util.initMod
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ListUserContainer(searchUserResultState: State<UiState<List<GithubUsersItem>>>) {
    Column {
        when (val listUiState = searchUserResultState.value) {
            UiState.Default -> {}
            UiState.Empty -> {
                Box(
                    modifier = initMod()
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        text = "Not Found",
                        fontSize = 32.sp,
                        fontFamily = nunitoFamily,
                        textAlign = TextAlign.Center,
                    )
                }
            }

            UiState.Loading -> {
                Box(
                    modifier = initMod()
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    DotsCollision()
                }
            }

            is UiState.Error -> {
                Box(
                    modifier = initMod()
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        text = listUiState.message,
                        fontSize = 32.sp,
                        fontFamily = nunitoFamily,
                        textAlign = TextAlign.Center,
                    )
                }
            }

            is UiState.Success -> {
                LazyColumn(
                    modifier = initMod(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(vertical = 16.dp),
                    content = {
                        items(listUiState.data) {
                            ListUserItem(user = it)
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL, wallpaper = Wallpapers.NONE, device = "spec:width=1079.9px,height=2400px")
@Composable
fun ListUserContainerPreviewEmpty() {
    ListUserContainer(MutableStateFlow<UiState<List<GithubUsersItem>>>(initUiStateEmpty()).collectAsState())
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListUserContainerPreviewLoading() {
    ListUserContainer(MutableStateFlow<UiState<List<GithubUsersItem>>>(initUiStateLoading()).collectAsState())
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListUserContainerPreview() {
    ListUserContainer(
        MutableStateFlow<UiState<List<GithubUsersItem>>>(
            arrayListOf<GithubUsersItem>().apply {
               add(GithubUsersItem(avatarUrl = "http://www.bing.com/search?q=ex", eventsUrl = "https://duckduckgo.com/?q=detraxit", followersUrl = "https://duckduckgo.com/?q=magna", followingUrl = "https://www.google.com/#q=quaestio", gistsUrl = "https://www.google.com/#q=referrentur", gravatarId = "dolor", htmlUrl = "https://search.yahoo.com/search?p=referrentur", id = 5301, login = "doctus", nodeId = "persecuti", organizationsUrl = "https://www.google.com/#q=reque", receivedEventsUrl = "https://www.google.com/#q=autem", reposUrl = "http://www.bing.com/search?q=tempus", score = 6.7, siteAdmin = false, starredUrl = "https://www.google.com/#q=his", subscriptionsUrl = "https://duckduckgo.com/?q=eruditi", type = "feugiat", url = "https://duckduckgo.com/?q=elitr"))
               add(GithubUsersItem(avatarUrl = "https://search.yahoo.com/search?p=ridens", eventsUrl = "https://duckduckgo.com/?q=legere", followersUrl = "https://duckduckgo.com/?q=ac", followingUrl = "http://www.bing.com/search?q=maiestatis", gistsUrl = "https://duckduckgo.com/?q=splendide", gravatarId = "malesuada", htmlUrl = "https://duckduckgo.com/?q=nec", id = 4379, login = "constituto", nodeId = "efficiantur", organizationsUrl = "https://search.yahoo.com/search?p=quas", receivedEventsUrl = "https://www.google.com/#q=ultricies", reposUrl = "https://search.yahoo.com/search?p=penatibus", score = 10.11, siteAdmin = false, starredUrl = "https://search.yahoo.com/search?p=mediocrem", subscriptionsUrl = "https://duckduckgo.com/?q=efficiantur", type = "expetendis", url = "https://www.google.com/#q=tristique"))
               add(GithubUsersItem(avatarUrl = "https://search.yahoo.com/search?p=salutatus", eventsUrl = "https://duckduckgo.com/?q=imperdiet", followersUrl = "http://www.bing.com/search?q=cubilia", followingUrl = "https://duckduckgo.com/?q=quaerendum", gistsUrl = "https://search.yahoo.com/search?p=mnesarchum", gravatarId = "rhoncus", htmlUrl = "http://www.bing.com/search?q=cursus", id = 5978, login = "falli", nodeId = "sollicitudin", organizationsUrl = "http://www.bing.com/search?q=postulant", receivedEventsUrl = "https://www.google.com/#q=elitr", reposUrl = "https://www.google.com/#q=dictumst", score = 14.15, siteAdmin = false, starredUrl = "https://search.yahoo.com/search?p=euismod", subscriptionsUrl = "https://search.yahoo.com/search?p=feugait", type = "eget", url = "https://www.google.com/#q=iisque"))
               add(GithubUsersItem(avatarUrl = "https://search.yahoo.com/search?p=neglegentur", eventsUrl = "https://duckduckgo.com/?q=magnis", followersUrl = "https://search.yahoo.com/search?p=verterem", followingUrl = "https://duckduckgo.com/?q=habitasse", gistsUrl = "https://www.google.com/#q=scelerisque", gravatarId = "repudiare", htmlUrl = "https://www.google.com/#q=maiorum", id = 1574, login = "necessitatibus", nodeId = "tractatos", organizationsUrl = "http://www.bing.com/search?q=enim", receivedEventsUrl = "https://www.google.com/#q=turpis", reposUrl = "https://search.yahoo.com/search?p=donec", score = 18.19, siteAdmin = false, starredUrl = "https://www.google.com/#q=eloquentiam", subscriptionsUrl = "https://search.yahoo.com/search?p=eu", type = "saperet", url = "https://search.yahoo.com/search?p=nisl"))
               add(GithubUsersItem(avatarUrl = "https://www.google.com/#q=ipsum", eventsUrl = "https://duckduckgo.com/?q=curae", followersUrl = "https://duckduckgo.com/?q=senserit", followingUrl = "https://search.yahoo.com/search?p=habeo", gistsUrl = "http://www.bing.com/search?q=putent", gravatarId = "principes", htmlUrl = "http://www.bing.com/search?q=justo", id = 9553, login = "dolore", nodeId = "vix", organizationsUrl = "https://www.google.com/#q=recteque", receivedEventsUrl = "http://www.bing.com/search?q=meliore", reposUrl = "https://search.yahoo.com/search?p=fabulas", score = 22.23, siteAdmin = false, starredUrl = "https://search.yahoo.com/search?p=aenean", subscriptionsUrl = "https://www.google.com/#q=scripta", type = "consul", url = "http://www.bing.com/search?q=antiopam"))
            }.toUiStateSuccess()
        ).collectAsState()
    )
}