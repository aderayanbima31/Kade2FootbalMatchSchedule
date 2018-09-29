package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model

import com.google.gson.annotations.SerializedName

data class EventResponseModel(
        @SerializedName("events")
        val match: List<Event>
)