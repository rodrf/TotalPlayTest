package com.universe.totalplaytest.domain.use_cases

import com.universe.totalplaytest.data.TotalplayRepository
import com.universe.totalplaytest.domain.model.LoginResponse
import javax.inject.Inject

class Login @Inject constructor(private val repository: TotalplayRepository) {
    suspend operator fun invoke(user: String, pass: String): LoginResponse{
        val response = repository.login(user, pass)
        //Here we can save session id to local storage
        return response
    }
}