package com.haris.truecaller.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haris.truecaller.viewmodels.MainViewModel

@Composable
fun Main(viewModel: MainViewModel) {
    val state = viewModel.state.collectAsState().value

    Box {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Button(onClick = { viewModel.fetch() }) {
                    Text(text = "click me")
                }
            }

            if (state.first.isNotEmpty() && state.second.isNotEmpty() && state.third.isNotEmpty()) {
                item { Text(text = "1st request: ${state.first}\n\n2nd request: ${state.second}\n\n3rd request: ${state.third}") }
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}