package com.example.androidtest.dashboard

import android.content.Context
import com.example.androidtest.R
import com.example.androidtest.recyclerview.ui.RecyclerViewFragment

sealed class BottomNavigationOption(val id: Int) {

    companion object {

        const val NO_ACTION = -1

        fun convertIdToBottomNavigationOption(actionId: Int): BottomNavigationOption {
            when (actionId) {
                RecyclerOption().id -> return RecyclerOption()
                else -> return NoActionOption()
            }
        }
    }

    abstract fun action(context: Context)

    //region Inner Classes

    class RecyclerOption : BottomNavigationOption(R.id.menu_bottom_option_recycler) {
        override fun action(context: Context) {
            if (context is DashboardActivity) {
                context.setFragment(RecyclerViewFragment.newInstance())
            }
        }
    }

    class NoActionOption : BottomNavigationOption(NO_ACTION) {
        override fun action(context: Context) {
            // Nothing to do
        }
    }

    //endregion
}

