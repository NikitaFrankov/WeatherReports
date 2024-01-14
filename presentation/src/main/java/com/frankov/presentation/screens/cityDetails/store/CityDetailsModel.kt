package com.frankov.presentation.screens.cityDetails.store

import com.frankov.common.Middleware
import com.frankov.common.StoreData
import com.frankov.common.makeStore
import com.frankov.common.model.ModelCoroutineScopeMain
import com.frankov.common.utils.AppDispatchers
import com.frankov.presentation.screens.cityDetails.store.CityDetailsEffect.*
import kotlinx.coroutines.CoroutineScope

internal class CityDetailsModel(
    middleware: Set<Middleware<CityDetailsEffect, CityDetailsState>>,
    dispatchers: AppDispatchers
): CityDetailsInteractor, CoroutineScope by ModelCoroutineScopeMain(dispatchers) {

    private val store = makeStore(
        StoreData(
            middleware = middleware,
            initState = CityDetailsState(),
            initEffects = listOf(Init),
            reducer = CityDetailsReducer(),
            dispatchers = dispatchers,
        )
    )

    override val stateFlow = store.stateFlow
    override val effectFlow = store.effectFlow

    override fun effect(effect: CityDetailsEffect) =
        store.effect(effect)
}