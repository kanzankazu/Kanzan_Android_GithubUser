package com.astro.test.faisalbahri.common.extensions

import com.astro.test.faisalbahri.common.model.DomainModel
import com.astro.test.faisalbahri.common.model.ResponseModel

interface DataToDomainModelMapper<R: ResponseModel, U: DomainModel> {
    fun mapToDomainModel(responseModel: R): U
}