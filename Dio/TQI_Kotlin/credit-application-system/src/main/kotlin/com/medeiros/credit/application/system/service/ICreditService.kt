package com.medeiros.credit.application.system.service

import com.medeiros.credit.application.system.entity.Credit
import java.util.*

interface ICreditService {
	fun save(credit: Credit): Credit
	fun findAllByCustomer(customerId: Long): List<Credit>
	fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}