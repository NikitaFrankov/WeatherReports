package com.frankov.data

import com.frankov.data.retrofit.RetrofitModule
import com.frankov.data.retrofit.RetrofitServicesModule

object DataModule {
    val module = RetrofitModule.module +
        RetrofitServicesModule.module
}