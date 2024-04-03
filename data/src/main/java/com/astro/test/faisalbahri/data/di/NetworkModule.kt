package com.astro.test.faisalbahri.data.di

import android.os.Build
import com.astro.test.faisalbahri.common.extensions.getEnv
import com.astro.test.faisalbahri.common.utils.ContextProvider
import com.astro.test.faisalbahri.data.remote.Api
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        val baseUrl = getEnv(null, "BASE_URL")
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(
        retrofit: Retrofit,
    ): Api = retrofit.create(Api::class.java)

    @Provides
    @Singleton
    fun provideHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        contextProvider: ContextProvider,
    ): OkHttpClient {
        val token = getEnv(null, "TOKEN")
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            OkHttpClient.Builder()
                .addInterceptor {
                    val request = it.request().newBuilder().addHeader("Authorization", "Bearer $token").build()
                    it.proceed(request)
                }
                .addInterceptor(
                    ChuckerInterceptor.Builder(contextProvider.getContext())
                        .collector(ChuckerCollector(contextProvider.getContext(), true))
                        .maxContentLength(250000L)
                        .redactHeaders(emptySet())
                        .alwaysReadResponseBody(false)
                        .build()
                )
                .addNetworkInterceptor(loggingInterceptor)
                .connectTimeout(Duration.ofSeconds(10))
                .readTimeout(Duration.ofSeconds(30))
                .build()
        } else {
            OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .build()
        }
    }

    @Provides
    @Singleton
    fun provideHttpLogger(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}