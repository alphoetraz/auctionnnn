package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class Login : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.blankFragment, R.id.blankFragment2, R.id.blankFragment3, R.id.blankFragment4))
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)


    }



}