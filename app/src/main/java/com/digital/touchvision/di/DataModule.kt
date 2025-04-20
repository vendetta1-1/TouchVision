package com.digital.touchvision.di

import com.digital.touchvision.data.repository.TouchVisionRepositoryImpl
import com.digital.touchvision.domain.repository.TouchVisionRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: TouchVisionRepositoryImpl): TouchVisionRepository

}