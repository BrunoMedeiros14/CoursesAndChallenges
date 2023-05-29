package com.medeiros.credit.application.system.entity

data class Customer(
	var firstName: String = "",
	var lastName: String = "",
	val cpf: String,
	var email: String = "",
	var password: String = "",
	var address: Adress = Adress(),
	var credits: List<Credit> = mutableListOf(),
	val id: Long? = null
)