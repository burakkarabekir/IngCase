package com.burakks.ingcase.data.cache.dao

import androidx.test.filters.SmallTest
import com.burakks.ingcase.data.cache.model.RepoEntity
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
@SmallTest
class RepoDaoTest : BaseDaoTest() {
    private lateinit var repoDao: RepoDao

    override fun setUp() {
        super.setUp()
        repoDao = database.repoDao()
    }

    @Test
    fun getRepoCount() = runBlockingTest {
        // Given
        repoDao.insertRepos(TEST_ENTRIES)
        // When
        val allRepoCount = repoDao.getRepoCount()
        // Then
        assertEquals(allRepoCount, TEST_ENTRIES.size)
    }

    @Test
    fun getRepos() = runBlockingTest {
        // Given
        repoDao.insertRepo(TEST_ENTRY)
        // When
        val allRepos = repoDao.getAllRepos()
        // Then
        assertEquals(allRepos[0].id, TEST_ENTRY.id)
        assertEquals(allRepos[0].name, TEST_ENTRY.name)
    }

    @Test
    fun doRepoExist() = runBlockingTest {
        // Given
        repoDao.insertRepo(TEST_ENTRY)
        // When
        val doRepoExist = repoDao.doRepoExist()
        // Then
        Assert.assertTrue(doRepoExist)
    }

    companion object {
        private val TEST_ENTRY = RepoEntity(1, "adessoTurkey", "adessoTurkey", false, 12, 21, 12, 12, "")
        private val TEST_ENTRIES = listOf(
            RepoEntity(1, "adessoTurkey", "adessoTurkey", false, 12, 21, 12, 12, ""),
            RepoEntity(2, "burakkarabekir", "burakkarabekir", false, 12, 21, 12, 12, ""),
            RepoEntity(3, "burakkarabekir", "burakkarabekir", false, 12, 21, 12, 12, ""),
        )
    }
}