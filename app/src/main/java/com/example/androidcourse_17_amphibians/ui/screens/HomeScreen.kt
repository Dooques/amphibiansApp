package com.example.androidcourse_17_amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcourse_17_amphibians.AmphibiansTopBar
import com.example.androidcourse_17_amphibians.data.TemporaryDataSource
import com.example.androidcourse_17_amphibians.model.AmphibianCard
import com.example.androidcourse_17_amphibians.ui.theme.AmphibiansTheme

@Composable
fun HomeScreen(
    amphibianUiState: AmphibianUiState,
) {
    when (amphibianUiState) {
        is AmphibianUiState.Loading -> BufferScreen(
            frogCard = TemporaryDataSource().bufferCard,
            modifier = Modifier.fillMaxSize(),
        )
        is AmphibianUiState.Success -> ResultsScreen(
            frogCards = amphibianUiState.amphibianCards,
            modifier = Modifier.fillMaxWidth()
        )
        is AmphibianUiState.Error -> ErrorScreen(
            frogCard = TemporaryDataSource().errorCard,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}



@Composable
fun LazyFrogColumn(
    frogCards: List<AmphibianCard>,
    modifier: Modifier = Modifier,
) {
    LazyColumn {
        items(
            items = frogCards,
            key = {item -> item.id}
        ) { item ->
            FrogCard(
                amphibian = item,
                modifier = modifier.padding(
                    vertical = 16.dp,
                    horizontal = 8.dp
                )

            )
        }
    }
}

@Composable
fun FrogCard(
    amphibian: AmphibianCard,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = stringResource(amphibian.name),
                fontSize = 32.sp,
                modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp)
            )
            Image(
                painter = painterResource(amphibian.imgUrl),
                contentDescription = "Cartoon Frog",
                contentScale = ContentScale.Crop,
                modifier = modifier.aspectRatio(16f / 9f)
            )
            Text(
                text = stringResource(amphibian.desc),
                fontSize = 16.sp,
                modifier = modifier.padding(
                    bottom = 8.dp,
                    start = 16.dp,
                    )
            )
        }
    }
}

@Composable
fun ResultsScreen(
    frogCards: List<AmphibianCard>,
    modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        LazyFrogColumn(
            frogCards = frogCards,
            modifier = modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun ErrorScreen(
    frogCard: AmphibianCard,
    modifier: Modifier = Modifier
) {
    Box (
        contentAlignment = Alignment.TopStart,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            FrogCard(
                amphibian = frogCard,
                modifier = modifier
            )
            Button(
                onClick = {},
                modifier = modifier
                    .fillMaxWidth(0.75f)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text("Retry")

            }
        }
    }
}

@Composable
fun BufferScreen(
    frogCard: AmphibianCard,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
        FrogCard(
            amphibian = frogCard,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    AmphibiansTheme {
        Scaffold {
            Surface(
                Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(Color.White)
            ) {
                ResultsScreen(
                    TemporaryDataSource().frogList,
                    modifier = Modifier
                    )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ErrorScreenPreview() {
    AmphibiansTheme {
        Scaffold(
            topBar = {
                AmphibiansTopBar(
                    scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
                    modifier = Modifier
                )
            }
        ) {
            Surface(
                Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                ErrorScreen(frogCard = TemporaryDataSource().errorCard)
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BufferScreenPreview() {
    AmphibiansTheme {
        Scaffold(
            topBar = {
                AmphibiansTopBar(
                    scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
                    modifier = Modifier
                )
            }
        ) {
            Surface(
                Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                BufferScreen(TemporaryDataSource().bufferCard)
            }
        }
    }
}
