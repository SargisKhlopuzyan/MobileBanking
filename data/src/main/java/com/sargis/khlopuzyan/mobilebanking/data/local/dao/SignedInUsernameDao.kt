package com.sargis.khlopuzyan.mobilebanking.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sargis.khlopuzyan.mobilebanking.data.local.entity.SignedInUsernameEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class SignedInUsernameDao {

    @Query("SELECT * FROM signed_in_user")
    abstract fun getAllSignedInUsers(): Flow<List<SignedInUsernameEntity>>

    @Query("SELECT * FROM signed_in_user WHERE id = :id")
    abstract suspend fun getSignedInUserById(id: Int): SignedInUsernameEntity?

    @Query("SELECT * FROM signed_in_user WHERE username = :username")
    abstract suspend fun getSignedInUserByUsername(username: String): SignedInUsernameEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertSignedInUser(user: SignedInUsernameEntity): Long

    @Delete
    abstract suspend fun deleteSignedInUser(user: SignedInUsernameEntity): Int
}