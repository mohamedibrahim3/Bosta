package com.mada.domain.entity

data class City(
    val id: String,
    val name: String,
    val districts: List<District>
)
