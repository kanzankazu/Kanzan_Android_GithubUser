@file:OptIn(ExperimentalMaterial3Api::class)

package com.astro.test.faisalbahri.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.astro.test.faisalbahri.presentation.ui.theme.PrimaryDark
import com.astro.test.faisalbahri.presentation.ui.theme.nunitoFamily
import com.astro.test.faisalbahri.presentation.util.initMod

@Composable
fun TitleTopBar(title: String, modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier
            .background(PrimaryDark),
        title = {
            Text(
                modifier = initMod()
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                text = title,
                color = Color.White,
                fontSize = 32.sp,
                fontFamily = nunitoFamily,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = PrimaryDark))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TitleTopBarPreview() {
    TitleTopBar("Kanzan",)
}