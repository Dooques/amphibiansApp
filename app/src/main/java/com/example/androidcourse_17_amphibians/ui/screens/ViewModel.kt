package com.example.androidcourse_17_amphibians.ui.screens

import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.androidcourse_17_amphibians.AmphibiansApplication
import com.example.androidcourse_17_amphibians.data.AmphibianRepository
import com.example.androidcourse_17_amphibians.model.AmphibianCard
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AmphibianUiState{
    data class Success(val amphibianCards: List<AmphibianCard>): AmphibianUiState
    data object Error : AmphibianUiState
    data object Loading : AmphibianUiState
}

class AmphibianViewModel(
    private val amphibianRepository: AmphibianRepository
): ViewModel() {
    var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set

    init {
        getFrogCards()
    }

    fun getFrogCards() {
        viewModelScope.launch {
            amphibianUiState = AmphibianUiState.Loading
            amphibianUiState = try {
                val frogList: List<AmphibianCard> = amphibianRepository.getAmphibianData()
                AmphibianUiState.Success(frogList)
            } catch (e: IOException) {
                AmphibianUiState.Error
            } catch (e: HttpException) {
                AmphibianUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibianRepository = application.container.amphibianRepository
                AmphibianViewModel(amphibianRepository = amphibianRepository)
            }
        }
    }


}