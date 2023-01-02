package com.haris.truecaller.di

import com.haris.truecaller.repositories.MainRepository
import com.haris.truecaller.repositories.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object MainModule {

    @Provides
    fun provideRepository(): MainRepository {
        return MainRepositoryImpl()
    }
}