package com.burakks.ingcase.data.cache.dao

import androidx.room.*
import com.burakks.ingcase.data.cache.model.RepoEntity

@Dao
interface RepoDao {
    @Insert
    suspend fun insertRepo(repo: RepoEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRepos(repos: List<RepoEntity>): LongArray

    @Update
    suspend fun updateRepo(repo: RepoEntity)

    @Query("SELECT * FROM repos WHERE id = :id")
    suspend fun getRepoById(id: Int): RepoEntity?

    @Query("DELETE FROM repos WHERE id IN (:ids)")
    suspend fun deleteRepos(ids: List<Int>): Int

    @Query("DELETE FROM repos")
    suspend fun deleteAllRepos()

    @Query("DELETE FROM repos WHERE id = :pk")
    suspend fun deleteRepo(pk: Int): Int

    @Query(
        """
        SELECT * FROM repos 
        ORDER BY id DESC """
    )
    suspend fun getAllRepos(
    ): List<RepoEntity>

    @Query("SELECT COUNT(*) FROM repos")
    suspend fun getRepoCount(): Int

    @Query("SELECT EXISTS(SELECT * FROM repos)")
    suspend fun doRepoExist(): Boolean
}