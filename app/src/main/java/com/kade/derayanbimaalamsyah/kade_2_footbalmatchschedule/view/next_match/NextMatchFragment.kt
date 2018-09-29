package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.next_match


import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.google.gson.Gson
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.R
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.adapter.NextMatchAdapter
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.adapter.PrevMatchAdapter
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.base_api.ApiRequest
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.Event
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.utils.SpaceItemDecoration
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class NextMatchFragment : Fragment(), NextMatchView {

    private var schedules: MutableList<Event> = mutableListOf()
    private lateinit var presenter: NextMatchPresenter
    private lateinit var adapter: NextMatchAdapter
    private lateinit var swipeRefresh : SwipeRefreshLayout
    private lateinit var listSchedules: RecyclerView
    private lateinit var progressBar : ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {
            frameLayout {
                lparams(matchParent, matchParent)
                swipeRefresh = swipeRefreshLayout {
                    id = R.id.swipeRefresh
                    setColorSchemeResources(R.color.colorAccent,
                            android.R.color.holo_green_light,
                            android.R.color.holo_orange_light,
                            android.R.color.holo_red_light)

                    relativeLayout {
                        lparams(matchParent, matchParent)

                        listSchedules = recyclerView{
                            id = R.id.recycleViewNextMatch
                            layoutManager = LinearLayoutManager(ctx)
                            addItemDecoration(SpaceItemDecoration(8))
                        }.lparams(matchParent, matchParent){
                            centerInParent()
                        }

                        progressBar = progressBar {
                            id = R.id.progressBarNextMatch
                        }.lparams {
                            centerHorizontally()
                        }

                    }
                }
            }
        }.view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAdapter()

        swipeRefresh.onRefresh {
            presenter.getEventList(getString(R.string.resource_eventsnextleague))
        }
    }

    private fun initAdapter(){
        adapter = NextMatchAdapter(schedules)
        listSchedules.adapter = adapter

        val request = ApiRequest()
        val gson = Gson()
        presenter = NextMatchPresenter(this, request, gson)
        presenter.getEventList(getString(R.string.resource_eventsnextleague))
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun showEventList(data: List<Event>?) {
        swipeRefresh.isRefreshing = false
        schedules.clear()
        if(data != null) schedules.addAll(data)
        else errorMessage(getString(R.string.next_event_not_found))
        if (schedules.size == 0) errorMessage(getString(R.string.next_event_not_found))
        adapter.notifyDataSetChanged()
    }

    override fun errorMessage(message: String?) {
    }

    companion object {
        fun nextMatchInstance(): NextMatchFragment = NextMatchFragment()
    }


}