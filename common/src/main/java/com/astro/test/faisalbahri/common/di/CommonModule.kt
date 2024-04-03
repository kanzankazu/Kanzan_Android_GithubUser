package com.astro.test.faisalbahri.common.di

import android.content.Context
import com.astro.test.faisalbahri.common.utils.ContextProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {

    @Singleton
    @Provides
    fun provideContextProvider(
        @ApplicationContext context: Context
    ): ContextProvider {
        return ContextProvider(context)
    }
}
