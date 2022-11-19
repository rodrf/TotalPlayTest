package com.universe.totalplaytest.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.viewModels
import com.universe.totalplaytest.R
import com.universe.totalplaytest.core.helpers.ActivityHelper
import com.universe.totalplaytest.core.utils.isValidAccount
import com.universe.totalplaytest.core.utils.isValidPassword
import com.universe.totalplaytest.databinding.ActivityLoginBinding
import com.universe.totalplaytest.ui.viewmodel.LoginViewModel
import com.universe.totalplaytest.ui.viewmodel.NetworkViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ActivityHelper(), OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()
    private val networkViewModel: NetworkViewModel by viewModels()
    private var netWorkConnected = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)
        initObservers()
    }

    private fun initObservers() {
        loginViewModel.session.observe(this) { idSession ->
            if (!idSession.isNullOrEmpty()) {
                val intent = Intent(this, ClientResponseActivity::class.java)
                intent.putExtra("idSession", idSession)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "Ocurrió un error al iniciar sesión, intente más tarde.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        loginViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                this.showLoader("Iniciando sesión...")
            } else {
                this.hideLoader()
            }

        }
    }

    override fun onResume() {
        super.onResume()
        networkViewModel.connected.observe(this) { connected ->
            netWorkConnected = connected
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnLogin.id -> {
                val account = binding.etAccount.text.toString()
                val password = binding.etPassword.text.toString()
                if (netWorkConnected) {
                    if (validateFields()) {
                        loginViewModel.login(account, password)
                    }
                } else {
                    Toast.makeText(
                        this,
                        getString(R.string.no_internet),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }

    private fun validateFields(): Boolean {
        var isValid = true
        if (!binding.etAccount.text.toString().isValidAccount()) {
            binding.etAccount.error = "Debe ser mayor a 4 caracteres"
            isValid = false
        }
        if (!binding.etPassword.text.toString().isValidPassword()) {
            binding.etPassword.error = "Almenos 8 caracteres"
            isValid = false
        }
        return isValid
    }

}