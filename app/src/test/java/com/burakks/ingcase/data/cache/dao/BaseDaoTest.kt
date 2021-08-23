package com.burakks.ingcase.data.cache.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import com.burakks.ingcase.data.cache.database.AppDatabase
import okio.IOException
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
@SmallTest
abstract class BaseDaoTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    protected lateinit var database: AppDatabase

    /**
     * Set up the dependencies and resources before every test.
     * Remember to call this method when inheriting from [BaseDaoTest]
     */
    @Before
    open fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
    }

    /**
     * Clear up dependencies and resources after every test.
     * Remember to call this method when inheriting from [BaseDaoTest]
     */
    @After
    @Throws(IOException::class)
    open fun tearDown() {
        database.close()
    }
}
