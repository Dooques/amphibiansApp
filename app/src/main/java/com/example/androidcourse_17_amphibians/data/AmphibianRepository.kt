package com.example.androidcourse_17_amphibians.data

import com.example.androidcourse_17_amphibians.model.AmphibianCard
import com.example.androidcourse_17_amphibians.network.AmphibianApiService

interface AmphibianRepository {
    suspend fun getAmphibianData(): List<AmphibianCard>
}

class NetworkAmphibianPhotosRepository(
    private val amphibianApiService: AmphibianApiService
) : AmphibianRepository {
    override suspend fun getAmphibianData(): List<AmphibianCard> =
        amphibianApiService.getFrogData()
}