package com.frankov.data.network.retrofit

import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal object RetrofitModule {
    private const val BASE_URL = "https://api.weatherapi.com/v1/"
    private const val TIMEOUT_SECS = 30L

    val module = module {
        single { LoggerRequestInterceptor() }
        single { provideGsonConverterFactory() }

        single() {
            provideRetrofit(
                client = get(),
                gsonConverterFactory = get()
            )
        }
        single() {
            provideApiClient(loggerInterceptor = get())
        }
    }

    private fun provideGsonConverterFactory() = GsonConverterFactory.create(Gson())

    private fun provideApiClient(
        loggerInterceptor: LoggerRequestInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(TIMEOUT_SECS, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_SECS, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_SECS, TimeUnit.SECONDS)
        .addInterceptor(loggerInterceptor)
        .build()

    private fun provideRetrofit(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(gsonConverterFactory)
        .build()
}