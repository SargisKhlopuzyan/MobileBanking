package com.sargis.khlopuzyan.mobilebanking.domain.usecase.login

import com.sargis.khlopuzyan.mobilebanking.domain.entity.User
import com.sargis.khlopuzyan.mobilebanking.domain.repository.UserRepository

class DeleteUserUseCase(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(user: User): Int {
        return userRepository.deleteUser(user)
    }
}