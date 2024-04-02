package com.astro.test.faisalbahri.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.astro.test.faisalbahri.domain.base.UiState
import com.astro.test.faisalbahri.presentation.R
import com.astro.test.faisalbahri.presentation.component.DotsCollision
import com.astro.test.faisalbahri.presentation.component.TitleTopBar
import com.astro.test.faisalbahri.presentation.ui.theme.nunitoFamily
import com.astro.test.faisalbahri.presentation.util.initMod

@Composable
fun ListUserScreen(viewModel: ListUserViewModel = hiltViewModel()) {

    var searchText by remember { mutableStateOf("") }
    val searchUserResultState = viewModel.users.collectAsState()

    Scaffold(
        topBar = { TitleTopBar(title = "Github Users") }
    ) {
        Column(
            modifier = initMod()
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = initMod()
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            ) {
                OutlinedTextField(
                    modifier = initMod()
                        .fillMaxWidth(),
                    value = searchText,
                    label = { Text(text = stringResource(id = R.string.label_search)) },
                    keyboardActions = KeyboardActions(),
                    onValueChange = { searchText = it }
                )

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
                                    val take = listUiState.data.take(5)
                                    val filter = take.filter { it.contains(searchText, true) }
                                    items(filter) {
                                        UserItem(user = it)
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UserItem(user: String, modifier: Modifier = Modifier) {
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
            Image(
                painter = painterResource(id = R.drawable.ic_user),
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
                    text = user,
                    fontFamily = nunitoFamily,
                    textAlign = TextAlign.Start,
                )
                Text(
                    modifier = initMod()
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Light,
                    text = "kanzan",
                    fontFamily = nunitoFamily,
                    textAlign = TextAlign.Start,
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListUserScreenPreview() {
    ListUserScreen()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserItemPreview() {
    UserItem("test")
}
