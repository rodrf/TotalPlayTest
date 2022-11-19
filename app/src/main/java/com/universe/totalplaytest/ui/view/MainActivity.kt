package com.universe.totalplaytest.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.universe.totalplaytest.core.helpers.ActivityHelper
import com.universe.totalplaytest.databinding.ActivityMainBinding

class MainActivity : ActivityHelper() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash= installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        screenSplash.setKeepOnScreenCondition{true}
        startActivity(Intent(this, LoginActivity::class.java))
        finish()

    }
}