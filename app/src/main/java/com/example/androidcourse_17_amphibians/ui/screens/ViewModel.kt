package com.example.androidcourse_17_amphibians.ui.screens

import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcourse_17_amphibians.data.TemporaryDataSource
import com.example.androidcourse_17_amphibians.model.AmphibianCard
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AmphibianUiState{
    data class Success(val amphibianCards: List<AmphibianCard>): AmphibianUiState
    data object Error : AmphibianUiState
    data object Loading : AmphibianUiState
}

class AmphibianViewModel: ViewModel() {
    var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set


    init {
        viewModelScope.launch {
            delay(5000)
            getFrogCards()
        }
    }

    fun getFrogCards() {
        viewModelScope.launch {
            amphibianUiState = AmphibianUiState.Loading
            amphibianUiState = try {
                AmphibianUiState.Success(TemporaryDataSource().frogList)
            } catch (e: IOException) {
                AmphibianUiState.Error
            } catch (e: HttpException) {
                AmphibianUiState.Error
            }
        }
    }


}