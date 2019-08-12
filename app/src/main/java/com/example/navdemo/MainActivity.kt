package com.example.navdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpNavGraph()
    }

    private fun setUpNavGraph() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        val integers = HashSet<Int>()
        integers.add(R.id.nav_home)
        integers.add(R.id.nav_connects)

        val appBarConfiguration = AppBarConfiguration.Builder(integers).setDrawerLayout(drawer).build()
        toolbar.setupWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawer)
    }
}
