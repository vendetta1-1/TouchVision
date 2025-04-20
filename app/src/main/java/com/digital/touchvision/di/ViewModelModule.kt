package com.digital.touchvision.di

import androidx.lifecycle.ViewModel
import com.digital.touchvision.presentation.home.HomeViewModel
import com.digital.touchvision.presentation.loading.LoadingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    @Binds
    fun bindHomeViewModel(impl: HomeViewModel): ViewModel

    @IntoMap
    @ViewModelKey(LoadingViewModel::class)
    @Binds
    fun bindLoadingViewModel(impl: LoadingViewModel): ViewModel
}