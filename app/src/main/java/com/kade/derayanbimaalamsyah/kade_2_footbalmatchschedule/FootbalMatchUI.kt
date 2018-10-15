package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule

import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class FootbalMatchUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {

        /*cardView {
            lparams(matchParent, wrapContent){
                topMargin = dip(8)
                leftMargin = dip(16)
                rightMargin = dip(16)
                radius = dip(4).toFloat()
            }

            linearLayout {
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER
                padding = dip(8)

                textView {
                    id = R.id.text_schedule
                    textColor = R.color.colorPrimary
                    gravity = Gravity.CENTER
                    setTypeface(null, Typeface.BOLD)
                    textSize = 16f
                }.lparams{
                    bottomMargin = dip(8)
                }

                linearLayout {
                    lparams(wrapContent, matchParent)
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL

                    textView {
                        id = R.id.text_hometeam
                        textSize = 20f
                        textColor = R.color.colorBlack
                    }.lparams(wrapContent, wrapContent) {

                    }

                    textView {
                        id = R.id.text_homescore
                        textSize = 24f
                        setTypeface(null, Typeface.BOLD)
                    }.lparams(wrapContent, wrapContent) {
                        leftMargin = dip(8)
                    }

                    textView {
                        id = R.id.text_versus
                        text = context.getString(R.string.resource_vs)
                        gravity = Gravity.CENTER
                        textSize = 18f
                    }.lparams(wrapContent,  wrapContent) {
                        leftMargin = dip(4)
                    }

                    textView {
                        id = R.id.textawayscore
                        setTypeface(null, Typeface.BOLD)
                        textSize = 24f
                    }.lparams(wrapContent, wrapContent) {
                        leftMargin = dip(4)
                    }

                    textView {
                        id = R.id.text_awayteam
                        textSize = 20f
                        textColor = R.color.colorBlack
                    }.lparams( wrapContent, wrapContent) {
                        leftMargin = dip(8)
                    }
                }
            }.lparams(matchParent, wrapContent) {
                margin = dip(8)
            }
        }*/

        cardView {
            lparams(matchParent, wrapContent) {
                topMargin = dip(8)
                leftMargin = dip(16)
                rightMargin = dip(16)
                radius = dip(4).toFloat()
            }

            linearLayout {
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER
                padding = dip(8)

                textView {
                    id = R.id.text_schedule
                    textColor = R.color.colorPrimary
                    gravity = Gravity.CENTER
                    setTypeface(null, Typeface.BOLD)
                    textSize = 16f
                }.lparams {
                    bottomMargin = dip(8)
                }

                linearLayout {
                    lparams(matchParent, wrapContent)
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL

                    textView {
                        id = R.id.text_hometeam
                        textSize = 20f
                        textColor = R.color.colorBlack
                        gravity = Gravity.CENTER
                    }.lparams(dip(0), wrapContent) {
                        weight = 1f
                    }

                    textView {
                        id = R.id.text_homescore
                        textSize = 24f
                        setTypeface(null, Typeface.BOLD)
                    }.lparams(wrapContent, wrapContent) {
                        leftMargin = dip(8)
                    }

                    textView {
                        id = R.id.text_versus
                        text = context.getString(R.string.resource_vs)
                        gravity = Gravity.CENTER
                        textSize = 18f
                    }.lparams(wrapContent, wrapContent) {
                        leftMargin = dip(4)
                    }

                    textView {
                        id = R.id.textawayscore
                        setTypeface(null, Typeface.BOLD)
                        textSize = 24f
                    }.lparams(wrapContent, wrapContent) {
                        leftMargin = dip(4)
                    }

                    textView {
                        id = R.id.text_awayteam
                        textSize = 20f
                        textColor = R.color.colorBlack
                        gravity = Gravity.CENTER
                    }.lparams(dip(0), wrapContent) {
                        leftMargin = dip(8)
                        weight = 1f
                    }
                }
            }.lparams(matchParent, wrapContent) {
                margin = dip(8)
            }
        }
    }

}
