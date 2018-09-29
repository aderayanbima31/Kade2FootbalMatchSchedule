package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.base_api

import java.net.URL


class ApiRequest  {

    fun doRequest(url: String) : String {
        return URL(url).readText()
    }

}