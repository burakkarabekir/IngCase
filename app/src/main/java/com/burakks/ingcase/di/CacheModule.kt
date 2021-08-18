package com.burakks.ingcase.di

import androidx.room.Room
import com.burakks.ingcase.TheApp
import com.burakks.ingcase.data.cache.dao.RepoDao
import com.burakks.ingcase.data.cache.database.AppDatabase
import com.burakks.ingcase.data.cache.model.RepoEntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideDatabase(app: TheApp): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRepoDao(db: AppDatabase): RepoDao {
        return  db.repoDao()
    }

    @Singleton
    @Provides
    fun provideCacheRepoMapper(): RepoEntityMapper {
        return RepoEntityMapper()
    }
}