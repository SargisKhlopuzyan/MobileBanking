package com.sargis.khlopuzyan.mobilebanking.domain.repository

import com.sargis.khlopuzyan.mobilebanking.domain.entity.LoginUserParam
import com.sargis.khlopuzyan.mobilebanking.domain.entity.RegisterUserParam
import com.sargis.khlopuzyan.mobilebanking.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getLastSignedInUsername(): String?
    fun saveLastSignedInUsername(username: String)
    suspend fun observeAllUser(): Flow<List<User>>
    suspend fun getUser(loginUserParam: LoginUserParam): User?
    suspend fun getUserByUsername(username: String): User?
    suspend fun registerUser(registerUserParam: RegisterUserParam): User?
    suspend fun deleteUser(userEntity: User): Int
    suspend fun isUserExist(username: String): Boolean
}