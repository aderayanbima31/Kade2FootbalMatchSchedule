package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.next_match

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.EventResponseModel
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.utils.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class NextMatchPresenter(private val view: NextMatchView,
                         private val apiRequest: ApiRequest,
                         private val gson: Gson,
                         private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getEventList(match: String?) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getSchedule(match)),
                        EventResponseModel::class.java
                )
            }
            view.showEventList(data.await().match)
            view.hideLoading()
        }
    }
}
