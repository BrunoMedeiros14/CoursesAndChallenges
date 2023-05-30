package com.medeiros.credit.application.system.dto

import java.math.BigDecimal
import java.util.*

class CreditViewList(
	val creditCode: UUID, val creditValue: BigDecimal, val numberOfInstallments: Int
)