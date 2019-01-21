package com.example.androidtest.dashboard

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import com.example.androidtest.BaseToolbarActivity
import com.example.androidtest.R
import com.example.androidtest.recyclerview.ui.RecyclerViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class DashboardActivity : BaseToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment(R.id.main_container, DashboardFragment.newInstance())
        setupBottomNavigation()
        setupToolbar()

    }

    fun setupToolbar() {
        setSupportActionBar(main_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val drawerToggle = ActionBarDrawerToggle(this, main_drawer, main_toolbar, 0, 0)
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerToggle.syncState()
    }

    fun setupBottomNavigation() {
        main_bottom_navigation.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.menu_bottom_option_recycler -> RecyclerViewActivity.startActivity(this@DashboardActivity)
                    else -> Log.i(javaClass.simpleName, "Nothing to do")
                }
                return true
            }
        })
    }

    override fun getToolbar(): Toolbar {
        return main_toolbar
    }
}
