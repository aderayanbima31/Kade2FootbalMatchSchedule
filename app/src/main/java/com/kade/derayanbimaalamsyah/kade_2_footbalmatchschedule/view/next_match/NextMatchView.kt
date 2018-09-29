package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.next_match

import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.Event

interface NextMatchView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>?)
    fun errorMessage(message: String?)
}
