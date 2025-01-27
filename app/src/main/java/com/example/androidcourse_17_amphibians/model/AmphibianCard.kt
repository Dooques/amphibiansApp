package com.example.androidcourse_17_amphibians.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AmphibianCard(
    val name: String,
    val type: String,
    @SerialName(value = "image_url") val imgUrl: String,
    val description: String,
)
