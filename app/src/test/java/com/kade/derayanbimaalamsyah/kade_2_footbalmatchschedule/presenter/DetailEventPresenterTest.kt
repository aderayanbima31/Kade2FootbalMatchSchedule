package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.presenter

import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.TestContextProvider
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.base_api.TheSportApi
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.Event
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.EventResponseModel
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.Team
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.TeamResponseModel
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.activity.detail.DetailMatchPresenter
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.activity.detail.DetailMatchView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailEventPresenterTest {

    @Mock
    private lateinit var view: DetailMatchView

    @Mock
    private lateinit var gson: Gson

    @Mock
    lateinit var apiRequest: ApiRequest

    private lateinit var presenter: DetailMatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailMatchPresenter(view, apiRequest, gson, TestContextProvider())
    }

    @Test
    fun testGetNextEvent() {
        val events: MutableList<Event> = mutableListOf()
        val home: MutableList<Team> = mutableListOf()
        val away: MutableList<Team> = mutableListOf()
        val response = EventResponseModel(events)
        val homeResponse = TeamResponseModel(home)
        val awayResponse = TeamResponseModel(away)
        val idEvent = "526916"
        val idHomeTeam = "134778"
        val idAwayTeam = "133613"

        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getDetailEvent(idEvent)),
                EventResponseModel::class.java)).thenReturn(response)
        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getHomeBadge(idHomeTeam)),
                TeamResponseModel::class.java)).thenReturn(homeResponse)
        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getAwayBadge(idAwayTeam)),
                TeamResponseModel::class.java)).thenReturn(awayResponse)

        presenter.getEventDetailMatch(idEvent, idHomeTeam, idAwayTeam)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEventList(events, home, away)
        Mockito.verify(view).hideLoading()
    }
}