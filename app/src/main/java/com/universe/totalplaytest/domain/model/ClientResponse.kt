package com.universe.totalplaytest.domain.model

import com.google.gson.annotations.SerializedName

data class ClientResponse(

	@field:SerializedName("arrayReferences")
	val arrayReferences: List<ArrayReferencesItem>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class ImagesItem(

	@field:SerializedName("url7X7")
	val url7X7: String? = null,

	@field:SerializedName("url6X6")
	val url6X6: String? = null,

	@field:SerializedName("url5X5")
	val url5X5: String? = null,

	@field:SerializedName("url4X4")
	val url4X4: String? = null,

	@field:SerializedName("url3X3")
	val url3X3: String? = null
)

data class ArrayReferencesItem(

	@field:SerializedName("reference")
	val reference: String? = null,

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("bank")
	val bank: String? = null,

	@field:SerializedName("aliasbank")
	val aliasbank: String? = null
)
