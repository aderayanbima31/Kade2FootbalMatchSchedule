package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.utils

import android.content.Context
import android.view.View
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.database.FavoriteDatabaseHelper

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

val Context.db: FavoriteDatabaseHelper
    get() = FavoriteDatabaseHelper.getInstance(applicationContext)
