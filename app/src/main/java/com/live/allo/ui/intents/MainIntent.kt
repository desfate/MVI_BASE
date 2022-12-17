package com.live.allo.ui.intents

sealed class MainIntent {

    data class submit(val info: String): MainIntent()

}