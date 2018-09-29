package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.activity.detail

import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.Event
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.Team

interface DetailMatchView {

    fun hideLoading()
    fun showLoading()
    fun showEventList(data: List<Event>, home: List<Team>, away: List<Team>)
}
