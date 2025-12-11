package com.sargis.khlopuzyan.mobilebanking.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sargis.khlopuzyan.mobilebanking.domain.entity.SignedInUsername

@Entity(tableName = "signed_in_username")
data class SignedInUsernameEntity(
    @PrimaryKey(autoGenerate = true)
    val signedInUserId: Int? = null,
    val username: String,
)

fun List<SignedInUsernameEntity>.toSignedInUsernameList() = map { singedInUsernameEntity ->
    singedInUsernameEntity.toSignedInUsername()
}

fun SignedInUsernameEntity.toSignedInUsername() = SignedInUsername(
    signedInUserId = signedInUserId,
    username = username,
)

fun SignedInUsername.toSignedInUsernameEntity() = SignedInUsernameEntity(
    signedInUserId = signedInUserId,
    username = username
)