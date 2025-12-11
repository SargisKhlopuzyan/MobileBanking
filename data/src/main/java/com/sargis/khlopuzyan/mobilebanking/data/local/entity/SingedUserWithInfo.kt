package com.sargis.khlopuzyan.mobilebanking.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation
import com.sargis.khlopuzyan.mobilebanking.domain.entity.SignedInUsername
import com.sargis.khlopuzyan.mobilebanking.domain.entity.User

data class SingedUserWithInfo(
    @Embedded
    val user: User,

    @Relation(
        parentColumn = "userId",
        entityColumn = "signedInUserId"
    )
    val signedInUsername: SignedInUsername,
)
