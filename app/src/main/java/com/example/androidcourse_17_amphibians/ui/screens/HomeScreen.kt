package com.example.androidcourse_17_amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcourse_17_amphibians.R
import com.example.androidcourse_17_amphibians.ui.theme.AmphibiansTheme

@Composable
fun HomeScreen() {

}

@Composable
fun LazyFrogColumn() {
    LazyColumn {
        items(
            count = 1,
            key = TODO(),
            contentType = TODO()
        ) {}
    }
}

@Composable
fun AmphibianCard(modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column {
            Text(
                text = stringResource(R.string.cartoon_frog),
                fontSize = 32.sp,
                modifier = modifier.padding(16.dp)
            )
            Image(
                painter = painterResource(R.drawable.cartoonfrog),
                contentDescription = "Cartoon Frog",
                contentScale = ContentScale.Crop,
                modifier = modifier.aspectRatio(16f / 9f)
            )
            Text(
                text = stringResource(R.string.ipsum_passage),
                fontSize = 16.sp,
                modifier = modifier.padding(16.dp)
            )
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    AmphibiansTheme {
        AmphibianCard()
    }
}