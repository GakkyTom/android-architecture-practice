package com.example.android_architecture_practice.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    val id: String,
    val name: String,
    val date: Long,
    val comment: String?,
    val path: String
)
