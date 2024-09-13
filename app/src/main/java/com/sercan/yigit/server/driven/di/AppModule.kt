package com.sercan.yigit.server.driven.di

import android.content.Context
import com.google.gson.Gson
import com.sercan.yigit.server.driven.data.repository.HomeScreenRepositoryImpl
import com.sercan.yigit.server.driven.domain.repository.HomeScreenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHomeScreenRepositoryImpl(gson: Gson, @ApplicationContext context: Context): HomeScreenRepository{
        return HomeScreenRepositoryImpl(gson = gson, context = context)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}