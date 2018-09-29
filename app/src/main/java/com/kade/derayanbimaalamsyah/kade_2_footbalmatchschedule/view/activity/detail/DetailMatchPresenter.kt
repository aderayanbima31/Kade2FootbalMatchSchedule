package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.activity.detail

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.EventResponseModel
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.TeamResponseModel
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.utils.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class DetailMatchPresenter(private val view: DetailMatchView,
                           private val apiRequest: ApiRequest,
                           private val gson: Gson,
                           private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun getEventDetailMatch(idEvent: String?, idHomeTeam: String?, idAwayTeam: String?) {
        view.showLoading()

        async(context.main) {
            val eventDetail = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getDetailEvent(idEvent)),
                        EventResponseModel::class.java)
            }
            val badgeHome = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getHomeBadge(idHomeTeam)),
                        TeamResponseModel::class.java)
            }
            val badgeAway = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getAwayBadge(idAwayTeam)),
                        TeamResponseModel::class.java)
            }
            view.showEventList(eventDetail.await().match, badgeHome.await().teams,
                    badgeAway.await().teams)
            view.hideLoading()
        }
    }
}