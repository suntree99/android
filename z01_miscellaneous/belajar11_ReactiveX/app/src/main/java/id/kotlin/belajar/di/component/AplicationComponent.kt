package id.kotlin.belajar.di.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import id.kotlin.belajar.BelajarApp
import id.kotlin.belajar.di.builder.ActivityBuilder
import id.kotlin.belajar.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    NetworkModule::class,
    ActivityBuilder::class
])

interface AplicationComponent : AndroidInjector<BelajarApp>