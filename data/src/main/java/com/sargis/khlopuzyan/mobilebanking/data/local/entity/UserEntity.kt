package com.sargis.khlopuzyan.mobilebanking.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sargis.khlopuzyan.mobilebanking.domain.entity.RegisterUserParam
import com.sargis.khlopuzyan.mobilebanking.domain.entity.User

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userId: Int? = null,
    val firstName: String,
    val lastName: String,
    val username: String,
    val password: String,
)

fun List<UserEntity>.toUserList() = map { userEntity ->
    userEntity.toUser()
}

fun UserEntity.toUser() = User(
    userId = userId,
    firstName = firstName,
    lastName = lastName,
    username = username,
    password = password
)

fun User.toUserEntity() = UserEntity(
    userId = userId,
    firstName = firstName,
    lastName = lastName,
    username = username,
    password = password
)

fun RegisterUserParam.toUserEntity() = UserEntity(
    firstName = firstName,
    lastName = lastName,
    username = username,
    password = password
)