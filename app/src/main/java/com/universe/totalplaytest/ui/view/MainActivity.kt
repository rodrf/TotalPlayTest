package com.universe.totalplaytest.ui.view

import android.content.Intent
import android.os.Bundle

import com.universe.totalplaytest.core.helpers.ActivityHelper
import com.universe.totalplaytest.databinding.ActivityMainBinding
import com.universe.totalplaytest.ui.login.LoginActivity

class MainActivity : ActivityHelper() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startActivity(Intent(this, LoginActivity::class.java))

    }
}