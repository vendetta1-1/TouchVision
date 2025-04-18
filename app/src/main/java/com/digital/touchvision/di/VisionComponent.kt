package com.digital.touchvision.di

import dagger.Component

@Component(
    modules = [DataModule::class]
)
@ApplicationScope
interface VisionComponent {

}