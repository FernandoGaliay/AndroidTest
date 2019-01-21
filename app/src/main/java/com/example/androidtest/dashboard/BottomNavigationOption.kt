package com.example.androidtest.dashboard

import android.content.Context
import com.example.androidtest.R
import com.example.androidtest.recyclerview.ui.RecyclerViewActivity

sealed class BottomNavigationOption(val id: Int) {

    companion object {
        fun convertIdToBottomNavigationOption(actionId: Int): BottomNavigationOption {
            when (actionId) {
                RecyclerOption().id -> return RecyclerOption()
                else -> return NoActionOption()
            }
        }
    }

    abstract fun startActivity(context: Context)

    /* Inner Classes */

    class RecyclerOption : BottomNavigationOption(R.id.menu_bottom_option_recycler) {
        override fun startActivity(context: Context) {
            RecyclerViewActivity.startActivity(context)
        }
    }

    class NoActionOption : BottomNavigationOption(-1){
        override fun startActivity(context: Context) {
            // Nothing to do
        }
    }
}

