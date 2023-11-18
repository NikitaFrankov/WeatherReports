package com.frankov.data.retrofit

import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal object RetrofitModule {
    private const val BASE_URL = "https://api.openweathermap.org/data/3.0/"
    private const val TIMEOUT_SECS = 30L

    val mainApiQualifier = named("MainApi")

    val module = module {
        single { LoggerRequestInterceptor() }
        single { provideGsonConverterFactory() }

        single(mainApiQualifier) {
            provideRetrofit(
                client = get(mainApiQualifier),
                gsonConverterFactory = get()
            )
        }
        single(mainApiQualifier) {
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