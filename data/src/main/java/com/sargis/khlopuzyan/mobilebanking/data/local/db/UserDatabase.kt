package com.sargis.khlopuzyan.mobilebanking.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import com.sargis.khlopuzyan.mobilebanking.data.local.dao.UserDao
import com.sargis.khlopuzyan.mobilebanking.data.local.entity.UserEntity
import kotlin.jvm.java

@Database(
    entities = [UserEntity::class],
    version = 8,
    exportSchema = true
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private const val DATABASE_NAME = "user_database"

        private val MIGRATION_7_8: Migration = Migration(7, 8) { supportSQLiteDatabase ->
//            supportSQLiteDatabase.execSQL("ALTER TABLE user ADD COLUMN phoneNumber TEXT")
            supportSQLiteDatabase.execSQL("ALTER TABLE user DROP COLUMN phoneNumber")
        }

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    DATABASE_NAME,
                )
//                    .addMigrations()
//                    .fallbackToDestructiveMigrationOnDowngrade(true)
//                    .fallbackToDestructiveMigration(false)
                    .addMigrations(MIGRATION_7_8)
//                    .setQueryCoroutineContext(Dispatchers.IO)
                    .build()
                INSTANCE = instance
                instance
            }
        }

        fun getTestInstance(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.inMemoryDatabaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}