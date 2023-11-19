package com.frankov.data.network.models

import com.frankov.data.network.models.StatusType.*

data class Resource<out T> (
    val statusType: StatusType,
    val data: T?,
    val message: String?
) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(
            statusType = SUCCESS,
            data = data,
            message = null
        )

        fun <T> error(
            data: T?,
            message: String
        ): Resource<T> = Resource(
            statusType = ERROR,
            data = data,
            message = message
        )

        fun <T> loading(data: T?): Resource<T> = Resource(
            statusType = LOADING,
            data = data,
            message = null
        )
    }
}
