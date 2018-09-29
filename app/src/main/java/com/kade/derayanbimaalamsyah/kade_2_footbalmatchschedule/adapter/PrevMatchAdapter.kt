package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.FootbalMatchUI
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.R
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.Event
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.activity.detail.DetailMatchActivity
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*

class PrevMatchAdapter(private val matches: List<Event>) : RecyclerView.Adapter<PrevViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrevViewHolder {
        return PrevViewHolder(FootbalMatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = matches.size

    override fun onBindViewHolder(holder: PrevViewHolder, position: Int) {
        holder.bindItem(matches[position])
    }


}

class PrevViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    private val timeSchedule: TextView = view.find(R.id.text_schedule)
    private val homeTeam: TextView = view.find(R.id.text_hometeam)
    private val homeScore: TextView = view.find(R.id.text_homescore)
    private val awayScore: TextView = view.find(R.id.textawayscore)
    private val awayTeam: TextView = view.find(R.id.text_awayteam)

    fun bindItem(matches: Event){

        val timeEvent = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                .parse(matches.dateEvent)

        val dateEvent = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
                .format(timeEvent)

        timeSchedule.text = dateEvent.toString()
        homeTeam.text = matches.strHomeTeam
        homeScore.text = matches.intHomeScore
        awayScore.text = matches.intAwayScore
        awayTeam.text = matches.strAwayTeam


        itemView.setOnClickListener {
            itemView.context.startActivity<DetailMatchActivity>(
                    itemView.context.getString(R.string.item_eventdetail_id) to matches.idEvent,
                    itemView.context.getString(R.string.item_home_id) to matches.idHomeTeam,
                    itemView.context.getString(R.string.item_away_id) to matches.idAwayTeam)

        }
    }


}


