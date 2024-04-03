@file:OptIn(ExperimentalGlideComposeApi::class, ExperimentalGlideComposeApi::class)

package com.astro.test.faisalbahri.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.astro.test.faisalbahri.domain.model.GithubUsersItem
import com.astro.test.faisalbahri.presentation.ui.theme.nunitoFamily
import com.astro.test.faisalbahri.presentation.util.initMod
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
fun ListUserItem(user: GithubUsersItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(75.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = initMod()
                .fillMaxSize()
                .padding(8.dp)
        ) {
            val rainbowColorsBrush = remember {
                Brush.sweepGradient(
                    listOf(
                        Color(0xFF9575CD),
                        Color(0xFFBA68C8),
                        Color(0xFFE57373),
                        Color(0xFFFFB74D),
                        Color(0xFFFFF176),
                        Color(0xFFAED581),
                        Color(0xFF4DD0E1),
                        Color(0xFF9575CD)
                    )
                )
            }
            val borderWidth = 4.dp
            GlideImage(
                model = user.avatarUrl,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        BorderStroke(borderWidth, rainbowColorsBrush),
                        CircleShape
                    )
                    .padding(borderWidth)
                    .clip(CircleShape)
            )
            Column(
                modifier = initMod()
                    .padding(start = 8.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    modifier = initMod()
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    text = user.login,
                    fontFamily = nunitoFamily,
                    textAlign = TextAlign.Start,
                )
                Text(
                    modifier = initMod()
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Light,
                    text = user.id.toString(),
                    fontFamily = nunitoFamily,
                    textAlign = TextAlign.Start,
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ListUserItemPreview() {
    ListUserItem(
        GithubUsersItem(
            avatarUrl = "https://www.google.com/#q=numquam",
            eventsUrl = "http://www.bing.com/search?q=eros",
            followersUrl = "https://www.google.com/#q=quo",
            followingUrl = "http://www.bing.com/search?q=quidam",
            gistsUrl = "https://search.yahoo.com/search?p=iuvaret",
            gravatarId = "dolorum",
            htmlUrl = "https://www.google.com/#q=repudiare",
            id = 1569,
            login = "expetendis",
            nodeId = "eros",
            organizationsUrl = "http://www.bing.com/search?q=erroribus",
            receivedEventsUrl = "http://www.bing.com/search?q=saepe",
            reposUrl = "https://www.google.com/#q=disputationi",
            score = 2.3,
            siteAdmin = false,
            starredUrl = "https://search.yahoo.com/search?p=honestatis",
            subscriptionsUrl = "https://duckduckgo.com/?q=vis",
            type = "accommodare",
            url = "https://search.yahoo.com/search?p=eleifend"

        )
    )
}
