package com.astro.test.faisalbahri.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.astro.test.faisalbahri.presentation.component.TypewriterText
import com.astro.test.faisalbahri.presentation.util.initMod

@Composable
fun SplashScreen(
    stringList: List<String>,
    onFinish: () -> Unit = {},
) {
    Column(
        modifier = initMod()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TypewriterText(
            stringList = stringList,
            modifier = initMod(),
            onFinish = onFinish
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StartScreenPreview() {
    SplashScreen(listOf("kanzan"))
}