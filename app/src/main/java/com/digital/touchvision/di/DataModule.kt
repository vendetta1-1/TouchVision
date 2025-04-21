package com.digital.touchvision.di

import com.digital.touchvision.data.remote.api.ApiFactory
import com.digital.touchvision.data.remote.api.ApiService
import com.digital.touchvision.data.repository.TouchVisionRepositoryImpl
import com.digital.touchvision.domain.repository.TouchVisionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: TouchVisionRepositoryImpl): TouchVisionRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService = ApiFactory.api
    }


}