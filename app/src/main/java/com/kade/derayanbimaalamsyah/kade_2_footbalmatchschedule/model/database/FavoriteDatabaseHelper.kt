package com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.model.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class FavoriteDatabaseHelper(ctx : Context) : ManagedSQLiteOpenHelper(ctx, "FavoriteFootball.db", null, 1) {


    override fun onCreate(db: SQLiteDatabase?) {

        db?.createTable(FavoriteParamsDatabase.TABLE_FAVORITE, true,
                FavoriteParamsDatabase.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                FavoriteParamsDatabase.EVENT_ID to TEXT + UNIQUE,
                FavoriteParamsDatabase.EVENT_TIME to  TEXT,
                FavoriteParamsDatabase.HOME_TEAM to TEXT,
                FavoriteParamsDatabase.HOME_SCORE to TEXT,
                FavoriteParamsDatabase.AWAY_TEAM to TEXT,
                FavoriteParamsDatabase.AWAY_SCORE to TEXT,
                FavoriteParamsDatabase.HOME_TEAM_ID to TEXT,
                FavoriteParamsDatabase.AWAY_TEAM_ID to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.dropTable(FavoriteParamsDatabase.TABLE_FAVORITE, true)
    }

    companion object {
        private var instance: FavoriteDatabaseHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): FavoriteDatabaseHelper{

            if (instance == null){
                instance = FavoriteDatabaseHelper(ctx.applicationContext)
            }

            return instance as FavoriteDatabaseHelper
        }
    }


}