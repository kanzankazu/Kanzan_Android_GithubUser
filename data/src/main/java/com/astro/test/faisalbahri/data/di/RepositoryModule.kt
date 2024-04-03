package com.astro.test.faisalbahri.data.di

import com.astro.test.faisalbahri.data.remote.datasource.DataSource
import com.astro.test.faisalbahri.data.repository.UserRepository
import com.astro.test.faisalbahri.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(dataSource: DataSource): UserRepository =
        UserRepositoryImpl(dataSource)
}