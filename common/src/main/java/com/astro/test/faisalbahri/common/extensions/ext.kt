package com.astro.test.faisalbahri.common.extensions

import io.github.cdimascio.dotenv.Dotenv

fun initEnv(): Dotenv {
    return Dotenv.configure().directory("./assets").filename("env").load()
}

fun getEnv(env: Dotenv?, key: String, default: String = ""): String {
    val dotenv = env ?: initEnv()
    return dotenv[key] ?: default
}