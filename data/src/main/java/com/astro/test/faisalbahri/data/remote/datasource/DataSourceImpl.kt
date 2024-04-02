package com.astro.test.faisalbahri.data.remote.datasource

import com.astro.test.faisalbahri.data.remote.Api
import javax.inject.Inject

internal class DataSourceImpl @Inject constructor(
    private val api: Api,
) : DataSource