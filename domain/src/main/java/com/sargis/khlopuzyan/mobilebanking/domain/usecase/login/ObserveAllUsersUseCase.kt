package com.sargis.khlopuzyan.mobilebanking.domain.usecase.login

import com.sargis.khlopuzyan.mobilebanking.domain.entity.User
import com.sargis.khlopuzyan.mobilebanking.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class ObserveAllUsersUseCase(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(): Flow<List<User>> {
        return userRepository.observeAllUser()
    }
}