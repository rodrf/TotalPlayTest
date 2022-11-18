package com.universe.totalplaytest.domain.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("session")
	val session: String? = null
)
