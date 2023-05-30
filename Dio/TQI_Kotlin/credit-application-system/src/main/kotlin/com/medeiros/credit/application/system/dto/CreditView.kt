package com.medeiros.credit.application.system.dto

import com.medeiros.credit.application.system.ennums.Status
import java.math.BigDecimal
import java.util.*

class CreditView(
	val creditCode: UUID,
	val creditValue: BigDecimal,
	val numberOfInstallment: Int,
	val status: Status,
	val emailCustomer: String?,
	val incomeCustomer: BigDecimal?
)