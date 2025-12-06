package com.sargis.khlopuzyan.mobilebanking.domain.entity

data class RegisterUserParam(
    val firstName: String,
    val lastName: String,
    val username: String,
    val password: String,
)