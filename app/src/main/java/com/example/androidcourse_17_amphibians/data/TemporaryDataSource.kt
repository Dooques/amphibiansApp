package com.example.androidcourse_17_amphibians.data

import androidx.compose.ui.res.stringResource
import com.example.androidcourse_17_amphibians.R
import com.example.androidcourse_17_amphibians.model.AmphibianCard
import com.example.androidcourse_17_amphibians.model.TempCard
import com.example.androidcourse_17_amphibians.ui.screens.FrogCard

class TemporaryDataSource {
    val frogList: List<TempCard> = listOf(
        TempCard(
            R.string.cartoon_frog,
            R.drawable.cartoonfrog,
            R.string.ipsum_passage
        ),
        TempCard(
            R.string.cartoon_frog,
            R.drawable.cartoonfrog,
            R.string.ipsum_passage
        ),
        TempCard(
            R.string.cartoon_frog,
            R.drawable.cartoonfrog,
            R.string.ipsum_passage
        )
    )
    val errorCard = TempCard(
        R.string.something_has_gone_wrong,
        R.drawable.sad_frog,
        R.string.click_below_to_try_again
    )
    val bufferCard = TempCard(
        R.string.buffering,
        R.drawable.sad_frog,
        R.string.buffering_desc
    )
}