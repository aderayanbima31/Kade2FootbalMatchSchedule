package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.favorite

import android.support.v4.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.R
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.R.string.*
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.adapter.FavoriteAdapter
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.database.FavoriteParamsDatabase
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.utils.SpaceItemDecoration
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.utils.db
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.utils.gone
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.activity.detail.DetailMatchActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class FavoriteFragment : Fragment(), AnkoComponent<Context> {

    private var favorites: MutableList<FavoriteParamsDatabase> = mutableListOf()
    private lateinit var listFavorite: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var adapter: FavoriteAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = FavoriteAdapter(favorites){
            ctx.startActivity<DetailMatchActivity>(
                    getString(item_eventdetail_id) to "${it.eventId}",
                    getString(item_home_id) to "${it.homeTeamId}",
                    getString(item_away_id) to "${it.awayTeamId}")
        }

        listFavorite.adapter = adapter
        showFavorite()
        swipeRefresh.onRefresh {
            favorites.clear()
            showFavorite()
        }


    }

    private fun showFavorite() {
        context?.db?.use {
            swipeRefresh.isRefreshing = false
            progressBar.gone()
            val result = select(FavoriteParamsDatabase.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<FavoriteParamsDatabase>())
            favorites.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createView(AnkoContext.Companion.create(ctx))
    }



    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        relativeLayout {

            lparams(matchParent, matchParent)

            swipeRefresh = swipeRefreshLayout {
                id = R.id.swipeRefresh
                setColorSchemeResources(R.color.colorAccent,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light)

                listFavorite = recyclerView {
                    lparams(matchParent, wrapContent)
                    id = R.id.recycleViewNextMatch
                    layoutManager = LinearLayoutManager(ctx)
                    addItemDecoration(SpaceItemDecoration(8))
                }
            }

            progressBar = progressBar {
                id = R.id.progressBarNextMatch
            }.lparams {
                centerHorizontally()
            }

        }

    }

    companion object {
        fun favoriteInstance() : FavoriteFragment = FavoriteFragment()
    }
}