package com.astro.test.faisalbahri.common.extensions

import com.astro.test.faisalbahri.common.utils.Resource

inline fun <T> Resource<T>.onSuccess(action: (value: T) -> Unit): Resource<T> {
    if (this is Resource.Success) action(this.data)
    return this
}

inline fun <T> Resource<T>.onFailure(action: (error: String) -> Unit): Resource<T> {
    if (this is Resource.Failure) action(error)
    return this
}