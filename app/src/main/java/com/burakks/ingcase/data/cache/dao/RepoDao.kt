package com.burakks.ingcase.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.burakks.ingcase.data.cache.model.RepoEntity

@Dao
interface RepoDao {
    @Insert
    suspend fun insertCountry(country: RepoEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCountries(countries: List<RepoEntity>): LongArray

    @Query("SELECT * FROM repos WHERE id = :id")
    suspend fun getCountryById(id: Int): RepoEntity?

    @Query("DELETE FROM repos WHERE id IN (:ids)")
    suspend fun deleteCountries(ids: List<Int>): Int

    @Query("DELETE FROM repos")
    suspend fun deleteAllCountries()

    @Query("DELETE FROM repos WHERE id = :pk")
    suspend fun deleteCountry(pk: Int): Int

    @Query(
        """
        SELECT * FROM repos 
        ORDER BY name DESC """
    )
    suspend fun getAllCountries(
    ): List<RepoEntity>
}