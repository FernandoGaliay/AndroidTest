package com.example.androidtest.dashboard

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.example.androidtest.BaseToolbarActivity
import com.example.androidtest.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : BaseToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setFragment(R.id.dashboard_container, DashboardFragment.newInstance())
        setupBottomNavigation()
        setupToolbar()

    }

    fun setupToolbar() {
        setSupportActionBar(dashboard_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val drawerToggle = ActionBarDrawerToggle(this, dashboard_drawer, dashboard_toolbar, 0, 0)
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerToggle.syncState()
    }

    fun setupBottomNavigation() {
        dashboard_navigation_bottom.setOnNavigationItemSelectedListener { menuItem ->
            BottomNavigationOption.convertIdToBottomNavigationOption(menuItem.itemId).startActivity(this@DashboardActivity)
            true
        }
    }

    override fun getToolbar(): Toolbar {
        return dashboard_toolbar
    }
}
