package com.frankov.data.network.retrofit

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

private const val REQUEST_TAG = "WeatherRequest"

internal class LoggerRequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val request = request()
        Log.e(REQUEST_TAG, "Request to ${request().url()}")
        proceed(request)
    }
}