package com.medeiros.credit.application.system.dto

import com.medeiros.credit.application.system.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

class CustomerToUpdateDto(
	@field:NotEmpty(message = "Invalid input") val firstName: String,
	@field:NotEmpty(message = "Invalid input") val lastName: String,
	@field:NotNull(message = "Invalid input") val income: BigDecimal,
	@field:NotEmpty(message = "Invalid input") val zipCode: String,
	@field:NotEmpty(message = "Invalid input") val street: String
) {

	fun toEntity(customer: Customer): Customer = customer.also { c ->
		c.firstName = firstName
		c.lastName = lastName
		c.income = income
		c.address.zipCode = zipCode
		c.address.street = street
	}

}