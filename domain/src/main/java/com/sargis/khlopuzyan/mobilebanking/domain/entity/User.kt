package com.sargis.khlopuzyan.mobilebanking.domain.entity

data class User(
    val userId: Int?,
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String,
)