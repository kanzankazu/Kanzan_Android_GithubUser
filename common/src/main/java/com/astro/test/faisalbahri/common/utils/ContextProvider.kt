package com.astro.test.faisalbahri.common.utils

import android.content.Context
import android.content.pm.PackageManager

class ContextProvider(
    private val context: Context
) {

    fun getContext(): Context = context

    fun getString(id : Int) : String  = context.getString(id)

    fun getPackageName(): String = context.packageName

    fun getPackageManager(): PackageManager = context.packageManager
}
