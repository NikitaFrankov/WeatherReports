package com.frankov.data

import com.frankov.data.network.dataSources.DataSourcesModule
import com.frankov.data.network.repositories.RepositoriesModule
import com.frankov.data.network.retrofit.RetrofitModule
import com.frankov.data.network.retrofit.RetrofitServicesModule

object DataModule {
    val module = RetrofitModule.module +
        RetrofitServicesModule.module +
        RepositoriesModule.module +
        DataSourcesModule.module
}