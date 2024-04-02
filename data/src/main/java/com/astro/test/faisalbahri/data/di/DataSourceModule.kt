package com.astro.test.faisalbahri.data.di

import com.astro.test.faisalbahri.data.remote.Api
import com.astro.test.faisalbahri.data.remote.datasource.DataSource
import com.astro.test.faisalbahri.data.remote.datasource.DataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Singleton
    @Provides
    fun provideRemoteDataSource(api: Api): DataSource =
        DataSourceImpl(api)
}