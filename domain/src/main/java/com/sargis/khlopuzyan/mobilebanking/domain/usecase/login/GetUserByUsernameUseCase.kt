package com.sargis.khlopuzyan.mobilebanking.domain.usecase.login

import com.sargis.khlopuzyan.mobilebanking.domain.entity.User
import com.sargis.khlopuzyan.mobilebanking.domain.repository.UserRepository

class GetUserByUsernameUseCase(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(username: String): User? {
        return userRepository.getUserByUsername(username)
    }
}