package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.FootbalMatchUI
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.R
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.database.FavoriteParamsDatabase
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.text.SimpleDateFormat
import java.util.*

class FavoriteAdapter(private val favorite: List<FavoriteParamsDatabase>, private val listener: (FavoriteParamsDatabase) -> Unit):
        RecyclerView.Adapter<FavoriteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {

        return FavoriteViewHolder(FootbalMatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = favorite.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bindItem(favorite[position], listener)    }
}

class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val timeSchedule: TextView = view.find(R.id.text_schedule)
    private val homeTeam: TextView = view.find(R.id.text_hometeam)
    private val homeScore: TextView = view.find(R.id.text_homescore)
    private val awayScore: TextView = view.find(R.id.textawayscore)
    private val awayTeam: TextView = view.find(R.id.text_awayteam)

    fun bindItem(favorite: FavoriteParamsDatabase, listener: (FavoriteParamsDatabase) -> Unit){

        val timeEvent = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                .parse(favorite.eventTime)
        val dateEvent = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
                .format(timeEvent)

        timeSchedule.text = dateEvent.toString()
        homeTeam.text = favorite.homeTeam
        homeScore.text = favorite.homeScore
        awayScore.text = favorite.awayScore
        awayTeam.text = favorite.awayTeam

        itemView.onClick {
            listener(favorite)
        }
    }

}
