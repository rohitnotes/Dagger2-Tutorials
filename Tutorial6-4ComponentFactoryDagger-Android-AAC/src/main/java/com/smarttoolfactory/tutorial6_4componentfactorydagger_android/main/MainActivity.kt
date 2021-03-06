package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.R
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.data.SettingsRepositoryImpl
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.AppComponent
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.domain.SettingsUseCase
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.settings.SettingsActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * * In this example Dagger-android, component factory and Clean architecture is used with scopes.
 *
 * * ViewModel, UseCase and Repository re-creation/retaining depends on whether they
 * are scoped with a scope or not.
 *
 * * If a ViewModel is annotated with scope [AppComponent] has, for instance @Singleton,
 * it's retained through the lifecycle of the app.
 *
 * * NotificationsViewModel is created using Activity and it's instance is RETAINED, and NOT
 * created every time new NotificationFragment is created.
 *
 * * [SettingsUseCase] is @Singleton so it's and [SettingsRepositoryImpl] also retained in it,
 * and returns values previously retrieved in [SettingsActivity]
 *
 */
class MainActivity : DaggerAppCompatActivity() {

    @Inject
     lateinit var viewModelFactory: ViewModelProvider.Factory

     private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.addOnBackStackChangedListener {

            val fragments = supportFragmentManager.fragments

            val backStackEntryCount = supportFragmentManager.backStackEntryCount

            Toast.makeText(MainActivity@ this, "Count: ${fragments.size}, backStackEntryCount: $backStackEntryCount, Fragments: $fragments", Toast.LENGTH_SHORT).show()
        }


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_settings -> {
                val settingsIntent = Intent(MainActivity@ this, SettingsActivity::class.java)
                startActivity(settingsIntent)
            }
        }
        return true
    }
}
