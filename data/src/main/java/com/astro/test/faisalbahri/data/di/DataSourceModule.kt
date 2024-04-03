package com.astro.test.faisalbahri.data.di

import com.astro.test.faisalbahri.data.remote.Api
import com.astro.test.faisalbahri.data.remote.datasource.UserDataSource
import com.astro.test.faisalbahri.data.remote.datasource.UserDataSourceImpl
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
    fun provideUserDataSource(api: Api): UserDataSource = UserDataSourceImpl(api)
}