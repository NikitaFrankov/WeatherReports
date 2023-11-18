package com.frankov.data.retrofit

import com.frankov.data.api.MainApi
import org.koin.dsl.module
import retrofit2.Retrofit

internal object RetrofitServicesModule {
    val module = module {
        single { get<Retrofit>(RetrofitModule.mainApiQualifier).create(MainApi::class.java) }
    }
}