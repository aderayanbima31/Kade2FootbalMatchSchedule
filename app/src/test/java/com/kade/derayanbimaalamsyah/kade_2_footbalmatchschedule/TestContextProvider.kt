package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule

import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.utils.CoroutineContextProvider
import kotlinx.coroutines.experimental.Unconfined
import kotlin.coroutines.experimental.CoroutineContext

class TestContextProvider :CoroutineContextProvider() {
    override val main: CoroutineContext = Unconfined
}