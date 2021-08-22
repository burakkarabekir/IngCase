package com.burakks.ingcase.di

import android.content.Context
import android.net.ConnectivityManager
import com.burakks.ingcase.BuildConfig
import com.burakks.ingcase.data.remote.model.RepoDtoMapper
import com.burakks.ingcase.data.remote.service.RepoService
import com.burakks.ingcase.util.Constants.BASE_URL
import com.burakks.ingcase.util.network.ConnectionType
import com.burakks.ingcase.util.network.connectionState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.StateFlow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRepoService(
        okHttpClient: OkHttpClient
    ): RepoService {
                  return Retrofit.Builder()
                      .client(okHttpClient)
                      .addConverterFactory(GsonConverterFactory.create())
                      .baseUrl(BASE_URL)
                      .build()
                      .create(RepoService::class.java)
    }

    @Singleton
    @Provides
    fun provideRepoDtoMapper(): RepoDtoMapper = RepoDtoMapper()


    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(10, TimeUnit.SECONDS)
        builder.readTimeout(10, TimeUnit.SECONDS)
        builder.writeTimeout(10, TimeUnit.SECONDS)
        builder.addInterceptor(loggingInterceptor)
        return builder.build()
    }
    
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return loggingInterceptor
    }

    @Provides
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @Provides
    @Singleton
    fun provideNetworkState(manager: ConnectivityManager): StateFlow<@JvmWildcard ConnectionType> =
        connectionState(manager)
}