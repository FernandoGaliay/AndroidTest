package com.example.androidtest.dashboard

import android.content.Context
import com.example.androidtest.R
import com.example.androidtest.recyclerview.ui.RecyclerViewActivity

sealed class BottomNavigationOption(val id: Int) {

    companion object {
        fun convertIdToBottomNavigationOption(actionId: Int): BottomNavigationOption {
            when (actionId) {
                RECYCLER().id -> return RECYCLER()
                else -> return NO_ACTION()
            }
        }
    }

    abstract fun startActivity(context: Context)

    /* Inner Classes */

    class RECYCLER : BottomNavigationOption(R.id.menu_bottom_option_recycler) {
        override fun startActivity(context: Context) {
            RecyclerViewActivity.startActivity(context)
        }
    }

    class NO_ACTION : BottomNavigationOption(-1){
        override fun startActivity(context: Context) {
            // Nothing to do
        }
    }
}

