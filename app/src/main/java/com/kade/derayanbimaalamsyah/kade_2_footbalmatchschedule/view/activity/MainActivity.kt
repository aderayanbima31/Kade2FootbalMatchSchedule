package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.activity

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.ActionBar
import android.widget.LinearLayout
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.R
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.R.color.colorPrimary
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.R.color.colorWhite
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.favorite.FavoriteFragment
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.next_match.NextMatchFragment
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.next_match.PrevMatchFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.design.bottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar as ActionBar

        LeagueActivityUI().setContentView(this)

        val bottomNavigation: BottomNavigationView = find(R.id.navigation)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigiationItemSelectedListener)

        if(savedInstanceState == null) {
            addFragment(PrevMatchFragment.prevMatchInstance())
        }


    }

    class LeagueActivityUI() : AnkoComponent<MainActivity> {
        @SuppressLint("NewApi")
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

            relativeLayout {
                lparams(width = matchParent, height = matchParent)

                frameLayout {
                    id = R.id.container
                }.lparams(width = matchParent, height = matchParent) {
                    above(R.id.bottom_layout)
                }

                linearLayout {
                    id = R.id.bottom_layout
                    orientation = LinearLayout.VERTICAL

                    view {
                        background = resources.getDrawable(R.drawable.highlight_shadow)
                    }.lparams(height = dip(4), width = matchParent)

                    bottomNavigationView {
                        id = R.id.navigation
                        inflateMenu(R.menu.navigation)
                        itemBackgroundResource = colorPrimary
                        backgroundColor = android.R.attr.windowBackground
                        itemTextColor = resources.getColorStateList(colorWhite)
                        itemIconTintList = resources.getColorStateList(colorWhite)
                    }.lparams(width = matchParent, height = wrapContent) {
                        marginEnd = dip(0)
                        marginStart = dip(0)
                    }
                }.lparams(width = matchParent, height = wrapContent) {
                    alignParentBottom()
                }
            }
        }
    }

    //class bottom navigation
    private val mOnNavigiationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){

            R.id.navigation_prev_league -> {
                val prevFragment = PrevMatchFragment.prevMatchInstance()
                addFragment(prevFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_next_league -> {
                val nextFragment = NextMatchFragment.nextMatchInstance()
                addFragment(nextFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_favorites ->{
                val favoFragment = FavoriteFragment.favoriteInstance()
                addFragment(favoFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}


