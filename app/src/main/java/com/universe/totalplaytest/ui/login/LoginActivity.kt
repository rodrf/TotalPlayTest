package com.universe.totalplaytest.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.viewModels
import com.universe.totalplaytest.R
import com.universe.totalplaytest.core.helpers.ActivityHelper
import com.universe.totalplaytest.databinding.ActivityLoginBinding
import com.universe.totalplaytest.ui.viewmodel.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ActivityHelper(), OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)

        loginViewModel.session.observe(this){existSession ->
            if(existSession){
                Toast.makeText(this, "LoginSucess", Toast.LENGTH_SHORT).show()
                Log.d("login_total", "LoginSuccess")
            }
        }

        loginViewModel.isLoading.observe(this){ isLoading ->
            if(isLoading){
                this.showLoader("Iniciando sesión...")
            }else{
                this.hideLoader()
            }

        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            binding.btnLogin.id->{
                val account = binding.etAccount.text.toString()
                val password = binding.etPassword.text.toString()
                if(!account.isNullOrEmpty() && !password.isNullOrEmpty()){
                    loginViewModel.login(account, password)
                }
            }
        }
    }
}