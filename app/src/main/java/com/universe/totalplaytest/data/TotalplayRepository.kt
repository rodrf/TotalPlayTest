package com.universe.totalplaytest.data

import com.universe.totalplaytest.data.network.TotalplayService
import com.universe.totalplaytest.domain.model.ClientResponse
import com.universe.totalplaytest.domain.model.LoginResponse
import com.universe.totalplaytest.domain.repository.ITotalplayRepository
import javax.inject.Inject

class TotalplayRepository @Inject constructor(private val api: TotalplayService): ITotalplayRepository {
    override suspend fun login(user: String, pass: String): LoginResponse {
        return api.login(user, pass)
    }

    override suspend fun clientResponse(session: String): ClientResponse {
        return api.clientResponse(session)
    }

}