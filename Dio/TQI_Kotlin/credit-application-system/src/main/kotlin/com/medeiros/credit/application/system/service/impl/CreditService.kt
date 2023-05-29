package com.medeiros.credit.application.system.service.impl

import com.medeiros.credit.application.system.entity.Credit
import com.medeiros.credit.application.system.repositories.CreditRepository
import com.medeiros.credit.application.system.service.ICreditService
import java.util.*

class CreditService(
	private val creditRepository: CreditRepository, private val customerService: CustomerService
) : ICreditService {
	override fun save(credit: Credit): Credit {
		credit.apply {
			customer = this.customer?.id?.let { customerService.findById(it) }
		}
		return creditRepository.save(credit)
	}

	override fun findAllByCustomer(customerId: Long): List<Credit> = creditRepository.findAllByCustomerId(customerId)

	override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
		val credit: Credit =
			creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("CreditCode $creditCode not found.")
		if (credit.customer?.id == customerId) return credit else throw RuntimeException("Contate o admin")
	}
}