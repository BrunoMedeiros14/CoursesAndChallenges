package com.medeiros.credit.application.system.dto

import java.math.BigDecimal

data class CustomerViewDto(
	val firstName: String,
	val lastName: String,
	val cpf: String,
	val income: BigDecimal,
	val zipCode: String,
	val street: String
)