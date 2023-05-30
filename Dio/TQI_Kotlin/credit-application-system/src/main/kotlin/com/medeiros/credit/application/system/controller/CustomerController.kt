package com.medeiros.credit.application.system.controller

import com.medeiros.credit.application.system.dto.CustomerDto
import com.medeiros.credit.application.system.dto.CustomerToUpdateDto
import com.medeiros.credit.application.system.dto.CustomerViewDto
import com.medeiros.credit.application.system.entity.Customer
import com.medeiros.credit.application.system.repositories.CustomerRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
	private val customerRepository: CustomerRepository
) {

	@GetMapping
	fun getAllCustomer(): List<CustomerViewDto> = customerRepository.findAll().map {
		it.run { CustomerViewDto(firstName, lastName, cpf, income, address.zipCode, address.street) }
	}

	@PostMapping
	fun saveCustomer(@RequestBody customerDto: CustomerDto): String =
		"Customer ${customerRepository.save(customerDto.toEntity()).firstName} salvo com sucesso."

	@GetMapping("/{id}")
	fun getById(@PathVariable id: Long): CustomerViewDto = customerRepository.findById(id).get().run {
		CustomerViewDto(firstName, lastName, cpf, income, address.zipCode, address.street)
	}

	@DeleteMapping("/{id}")
	fun deleteById(@PathVariable id: Long) = customerRepository.deleteById(id)

	@PatchMapping("/{id}")
	fun updateCustomer(@PathVariable id: Long, @RequestBody customerToUpdateDto: CustomerToUpdateDto): CustomerViewDto {
		val customer: Customer = customerRepository.findById(id).get()
		val updatedCustomer: Customer = customerToUpdateDto.toEntity(customer)
		return customerRepository.save(updatedCustomer).run {
			CustomerViewDto(firstName, lastName, cpf, income, address.zipCode, address.street)
		}
	}

}