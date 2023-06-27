package com.example.auratestapp

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.example.auratestapp.AuraTestViewModel

val appModule = module {

    viewModelOf(::AuraTestViewModel)
    singleOf(::AuraTestViewRepository)
}