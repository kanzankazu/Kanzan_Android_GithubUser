@file:Suppress("UNCHECKED_CAST")

package com.astro.test.faisalbahri.presentation.base

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

abstract class BaseActivityBindingCompose : ComponentActivity() {

    @Composable
    protected abstract fun SetContentCompose()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetContentCompose()
        }
    }
}
