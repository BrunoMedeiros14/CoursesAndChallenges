package com.medeiros.credit.application.system.service.impl

import com.medeiros.credit.application.system.entity.Customer
import com.medeiros.credit.application.system.exception.BusinessException
import com.medeiros.credit.application.system.repositories.CustomerRepository
import com.medeiros.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
	private val customerRepository: CustomerRepository
) : ICustomerService {

	override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

	override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow {
		throw BusinessException("Id $id not found")
	}

	fun findAll(): List<Customer> = this.customerRepository.findAll()

	override fun delete(id: Long) = this.customerRepository.deleteById(id)

}