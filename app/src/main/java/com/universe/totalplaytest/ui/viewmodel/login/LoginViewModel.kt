package com.universe.totalplaytest.ui.viewmodel.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universe.totalplaytest.domain.use_cases.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val doLogin: Login
): ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val session = MutableLiveData<Boolean>()

    fun login(user: String, password: String){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = doLogin(user, password)
            result?.let { response ->
                if(response.session != null && !response.session.toString().isNullOrEmpty())
                    //Save idSession to localStorage
                    Log.d("login_total", "session: ${response.session}")
                    session.postValue(true)
            }
            isLoading.postValue(false)
        }
    }
}