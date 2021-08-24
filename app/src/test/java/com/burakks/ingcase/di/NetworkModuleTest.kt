package com.burakks.ingcase.di

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.burakks.ingcase.BuildConfig
import com.burakks.ingcase.data.remote.service.RepoService
import com.burakks.ingcase.util.Constants.BASE_URL
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.create

@ExperimentalCoroutinesApi
@SmallTest
class NetworkModuleTest {

    private lateinit var networkModule: NetworkModule
    private lateinit var retrofit: Retrofit

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        networkModule = NetworkModule
        retrofit = mockk()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun provideLoggingInterceptor() = runBlockingTest {
        val interceptor = networkModule.provideLoggingInterceptor()
        val logLevel =
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        assertEquals(logLevel, interceptor.level)
    }

    @Test
    fun provideOkHttpClient() = runBlockingTest {
        val loggingInterceptor = mockk<HttpLoggingInterceptor>()

        val client = networkModule.provideOkHttpClient(
            loggingInterceptor,
        )

        assertNotNull(client)

        with(client.interceptors) {
            assertNotEquals(6, size)
            assertEquals(1, size)
            assertTrue(contains(loggingInterceptor))
        }
    }

    @Test
    fun provideRetrofit() = runBlockingTest {
        val client = mockk<OkHttpClient>()

        val retrofit = networkModule.provideRetrofit(client)

        assertEquals(BASE_URL, retrofit.baseUrl().toUrl().toString())
    }

    @Test
    fun provideRepoService() = runBlockingTest {
        val repoService = mockk<RepoService>()

        every {
            retrofit.create<RepoService>()
        } returns repoService

        val actualService = networkModule.provideRepoService(retrofit)

        assertEquals(repoService, actualService)
    }
}
