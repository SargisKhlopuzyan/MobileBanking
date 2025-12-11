package com.sargis.khlopuzyan.mobilebanking.data.local.source

import com.sargis.khlopuzyan.mobilebanking.data.local.dao.SignedInUsernameDao
import com.sargis.khlopuzyan.mobilebanking.data.local.entity.UserEntity
import com.sargis.khlopuzyan.mobilebanking.data.local.sharedPreferences.AppSettingsSharedPref
import kotlinx.coroutines.flow.Flow

interface SignedInUsernameDataSource {
    fun getLastSignedInUsername(): String?
    fun saveLastSignedInUsername(username: String)

    fun observeAllUsernames(): Flow<List<UserEntity>>
    suspend fun getUserById(id: Int): UserEntity?
    suspend fun getUserByUsername(username: String): UserEntity?
    suspend fun insertUsername(node: UserEntity): Int
    suspend fun deleteUsername(node: UserEntity): Int
}

class SignedInUsernameDataSourceImpl(
    val appSettingsSharedPref: AppSettingsSharedPref,
    val dao: SignedInUsernameDao,
) : SignedInUsernameDataSource {
    override fun getLastSignedInUsername(): String? {
        return appSettingsSharedPref.getLastSignedInUsername()
    }

    override fun saveLastSignedInUsername(username: String) {
        appSettingsSharedPref.saveLastSignedInUsername(username)
    }

    override fun observeAllUsernames(): Flow<List<UserEntity>> {
        return dao.getAllSignedInUsers()
    }

    override suspend fun getUserById(id: Int): UserEntity? {
        return dao.getUserById(id)
    }

    override suspend fun getUserByUsername(username: String): UserEntity? {
        return dao.getUserByUsername(username)
    }

    override suspend fun insertUsername(user: UserEntity): Int {
        return dao.insertUser(user).toInt()
    }

    override suspend fun deleteUsername(user: UserEntity): Int {
        return dao.deleteUser(user)
    }
}