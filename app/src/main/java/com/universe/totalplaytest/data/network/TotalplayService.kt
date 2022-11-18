package com.universe.totalplaytest.data.network

import android.util.Log
import com.universe.totalplaytest.data.model.DataLogin
import com.universe.totalplaytest.domain.model.ClientResponse
import com.universe.totalplaytest.domain.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TotalplayService @Inject constructor(private val api: TotalplayApiClient) {

    suspend fun login(user: String, pass: String): LoginResponse{
        return withContext(Dispatchers.IO){
            try {
                val dataLogin = DataLogin(user, pass)
                val response = api.login(dataLogin)
                response.body() ?: LoginResponse()
            }catch (ex: java.lang.Exception){
                Log.d("login", ex.message.toString())
                LoginResponse()
            }
        }
    }
    suspend fun clientResponse(session: String): ClientResponse{
        return withContext(Dispatchers.IO){
            try {
                val mapData = mapOf("session" to session)
                val response = api.clientResponse(mapData)
                response.body() ?: ClientResponse()
            }catch (ex: java.lang.Exception){
                ClientResponse()
            }
        }
    }

}