package com.universe.totalplaytest.domain.repository

import com.universe.totalplaytest.domain.model.ClientResponse
import com.universe.totalplaytest.domain.model.LoginResponse

interface ITotalplayRepository {
    suspend fun login(user: String, pass: String): LoginResponse
    suspend fun clientResponse(session: String): ClientResponse
}