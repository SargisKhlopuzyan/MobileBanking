package com.sargis.khlopuzyan.mobilebanking.domain.usecase.login

import com.sargis.khlopuzyan.mobilebanking.domain.repository.UserRepository

class GetLastSignedInUsernameUseCase(
    private val userRepository: UserRepository,
) {
    operator fun invoke(): String? {
        return userRepository.getLastSignedInUsername()
    }
}