package com.santimattius.kmp.sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.santimattius.kmp.BadImplementation
import com.santimattius.kmp.Greeting
import com.santimattius.kmp.Sdk
import com.santimattius.kmp.context.PlatformContext
import com.santimattius.kmp.context.Storage
import kotlinx.coroutines.launch

@OptIn(BadImplementation::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            val greeting = remember { Greeting().greet() }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(painterResource(R.drawable.compose_multiplatform), null)
                Text("Compose: $greeting")
            }
            Button(onClick = {
                Sdk.logger.logException(IllegalStateException("Button clicked"))
            }) {
                Text("Click me!")
            }
            val context = LocalContext.current
            val coroutineScope = rememberCoroutineScope()
            Button(onClick = {
                /*Storage.write(
                    context = PlatformContext(context = context),
                    key = "key",
                    value = "value"
                )*/
                coroutineScope.launch {
                    Sdk.getKvs().write(
                        key = "key",
                        value = "value"
                    )
                }
            }) {
                Text("Save into storage")
            }
        }
    }
}