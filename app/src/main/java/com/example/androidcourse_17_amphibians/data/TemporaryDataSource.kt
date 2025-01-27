package com.example.androidcourse_17_amphibians.data

import androidx.compose.ui.res.stringResource
import com.example.androidcourse_17_amphibians.R
import com.example.androidcourse_17_amphibians.model.AmphibianCard
import com.example.androidcourse_17_amphibians.ui.screens.FrogCard

class TemporaryDataSource {
    val frogList: List<AmphibianCard> = listOf(
        AmphibianCard(
            1,
            R.string.cartoon_frog,
            R.drawable.cartoonfrog,
            R.string.ipsum_passage
        ),
        AmphibianCard(
            2,
            R.string.cartoon_frog,
            R.drawable.cartoonfrog,
            R.string.ipsum_passage
        ),
        AmphibianCard(
            3,
            R.string.cartoon_frog,
            R.drawable.cartoonfrog,
            R.string.ipsum_passage
        )
    )
    val errorCard = AmphibianCard(
        0,
        R.string.something_has_gone_wrong,
        R.drawable.sad_frog,
        R.string.click_below_to_try_again
    )
    val bufferCard = AmphibianCard(
        0,
        R.string.buffering,
        R.drawable.sad_frog,
        R.string.buffering_desc
    )
}