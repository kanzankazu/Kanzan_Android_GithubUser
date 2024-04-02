package com.astro.test.faisalbahri.presentation.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.astro.test.faisalbahri.presentation.ui.theme.nunitoFamily
import kotlinx.coroutines.delay

@Composable
fun TypewriterText(
    stringList: List<String>,
    modifier: Modifier = Modifier,
    onFinish: () -> Unit = {},
) {
    var textIndex by remember { mutableIntStateOf(0) }
    var textToDisplay by remember { mutableStateOf("") }

    LaunchedEffect(
        key1 = stringList,
    ) {
        while (textIndex < stringList.size) {
            stringList[textIndex].forEachIndexed { charIndex, _ ->
                textToDisplay = stringList[textIndex].substring(
                    startIndex = 0,
                    endIndex = charIndex + 1,
                )
                delay(150)
            }
            textIndex = (textIndex + 1) % stringList.size
            delay(1000)
            if (textIndex == 0) {
                onFinish.invoke()
                break
            }
        }
    }

    Text(
        textAlign = TextAlign.Center,
        modifier = modifier,
        text = textToDisplay,
        fontFamily = nunitoFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TypewriterTextPreview() {
    TypewriterText(listOf("Typewriter Text Preview")) {}
}