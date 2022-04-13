package com.example.a6_navigationcomponentpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.a6_navigationcomponentpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            navController = findNavController(R.id.fragmentContainerView)
            bottomNavigation.setupWithNavController(navController)

            appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFrag,R.id.searchFrag,R.id.favoriteFrag,R.id.contactFrag,R.id.moreFrag))
            setupActionBarWithNavController(navController,appBarConfiguration)
        }
    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp()||super.onNavigateUp()
    }
}