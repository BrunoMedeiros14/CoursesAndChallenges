package com.medeiros.credit.application.system.dto

import com.medeiros.credit.application.system.entity.Credit
import com.medeiros.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
	val creditValue: BigDecimal, val dayFirstOfInstallment: LocalDate, val numberOfInstallments: Int, val customerId: Long
) {

	fun toEntity(): Credit = Credit(
		creditValue = this.creditValue,
		dayFirstOfInstallment = this.dayFirstOfInstallment,
		numberOfInstallments = this.numberOfInstallments,
		customer = Customer(id = this.customerId)
	)
}
