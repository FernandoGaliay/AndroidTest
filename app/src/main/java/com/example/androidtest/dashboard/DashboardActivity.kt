package com.example.androidtest.dashboard

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import com.example.androidtest.BaseToolbarActivity
import com.example.androidtest.R
import com.example.androidtest.recycler.ui.RecyclerActivity
import com.example.androidtest.viewmodel.InitializationViewModel
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : BaseToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragment(DashboardFragment.newInstance())
        setupBottomNavigation()
        setupToolbar()
        setupNavitation()
        val viewModel = ViewModelProviders.of(this).get(InitializationViewModel::class.java)
        viewModel.startSync(this)

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
            BottomNavigationOption.convertIdToBottomNavigationOption(menuItem.itemId).action(this@DashboardActivity)
            true
        }
    }

    fun setupNavitation() {
        dashboard_navigation_drawer.setNavigationItemSelectedListener(
                object : NavigationView.OnNavigationItemSelectedListener {
                    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                        when (menuItem.itemId) {
                            R.id.menu_main_option_recycler -> RecyclerActivity.startActivity(this@DashboardActivity)
                            else -> Log.w(this.javaClass.simpleName, "NO OPTION MAPPED");
                        }
                        return true
                    }
                }
        )
    }

    override fun getToolbar(): Toolbar {
        return dashboard_toolbar
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_dashboard
    }

    override fun getContainerId(): Int {
        return R.id.dashboard_container
    }
}
