package com.example.androidcourse_17_amphibians.network

import com.example.androidcourse_17_amphibians.model.AmphibianCard
import retrofit2.http.GET

interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getFrogData(): List<AmphibianCard>
}