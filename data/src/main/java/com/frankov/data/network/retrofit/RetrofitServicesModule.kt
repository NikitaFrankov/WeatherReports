package com.frankov.data.network.retrofit

import com.frankov.data.network.api.MainApi
import org.koin.dsl.module
import retrofit2.Retrofit

internal object RetrofitServicesModule {
    val module = module {
        single { get<Retrofit>().create(MainApi::class.java) }
    }
}