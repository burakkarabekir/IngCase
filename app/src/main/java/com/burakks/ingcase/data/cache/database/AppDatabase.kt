package com.burakks.ingcase.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.burakks.ingcase.data.cache.dao.RepoDao
import com.burakks.ingcase.data.cache.model.RepoEntity

@Database(
    entities = [RepoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao

    companion object {
        const val DATABASE_NAME: String = "repo_db"
    }
}