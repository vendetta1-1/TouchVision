package com.digital.touchvision.di

import androidx.lifecycle.ViewModel
import kotlin.reflect.KClass
import dagger.MapKey

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)