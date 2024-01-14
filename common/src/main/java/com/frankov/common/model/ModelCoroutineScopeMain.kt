package com.frankov.common.model

import com.frankov.common.utils.AppDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ModelCoroutineScopeMain(dispatchers: AppDispatchers) : CoroutineScope {
    override val coroutineContext = SupervisorJob() + dispatchers.main
}