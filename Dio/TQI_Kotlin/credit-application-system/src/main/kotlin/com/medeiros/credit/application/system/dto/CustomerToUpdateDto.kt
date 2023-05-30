package com.medeiros.credit.application.system.dto

import com.medeiros.credit.application.system.entity.Customer
import java.math.BigDecimal

class CustomerToUpdateDto(
	val firstName: String,
	val lastName: String,
	val income: BigDecimal,
	val zipCode: String,
	val street: String
) {

	fun toEntity(customer: Customer): Customer = customer.also { c ->
		c.firstName = firstName
		c.lastName = lastName
		c.income = income
		c.address.zipCode = zipCode
		c.address.street = street
	}

}