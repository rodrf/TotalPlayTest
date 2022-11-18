package com.universe.totalplaytest.domain.use_cases

import com.universe.totalplaytest.data.TotalplayRepository
import com.universe.totalplaytest.domain.model.ClientResponse
import javax.inject.Inject

class ClientDetail @Inject constructor(private val repository: TotalplayRepository) {
    suspend operator fun invoke(idSession: String): ClientResponse{
        val response = repository.clientResponse(idSession)
        return response
    }
}