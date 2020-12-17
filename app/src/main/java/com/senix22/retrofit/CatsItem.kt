package com.senix22.retrofit

data class CatsItem(
    val _id: String,
    val source: String,
    val status: Status,
    val text: String,
    val type: String,
    val user: String
)