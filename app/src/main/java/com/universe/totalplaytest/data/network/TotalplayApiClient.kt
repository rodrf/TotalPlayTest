package com.universe.totalplaytest.data.network

import com.universe.totalplaytest.data.model.DataLogin
import com.universe.totalplaytest.domain.model.ClientResponse
import com.universe.totalplaytest.domain.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface TotalplayApiClient {

    @POST("cliente.do")
    suspend fun login(@Body dataLogin: DataLogin): Response<LoginResponse>

    @POST("clienteresp.do")
    suspend fun clientResponse(@Body login: Map<String, String>): Response<ClientResponse>

}