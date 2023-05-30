package com.medeiros.credit.application.system.controller

import com.medeiros.credit.application.system.dto.CustomerDto
import com.medeiros.credit.application.system.dto.CustomerToUpdateDto
import com.medeiros.credit.application.system.dto.CustomerViewDto
import com.medeiros.credit.application.system.entity.Customer
import com.medeiros.credit.application.system.repositories.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
	private val customerRepository: CustomerRepository
) {

	@GetMapping
	fun getAllCustomer(): ResponseEntity<List<CustomerViewDto>> =
		ResponseEntity.status(HttpStatus.OK).body(customerRepository.findAll().map {
			it.run { CustomerViewDto(firstName, lastName, cpf, income, address.zipCode, address.street) }
		})

	@PostMapping
	fun saveCustomer(@RequestBody customerDto: CustomerDto): ResponseEntity<String> =
		ResponseEntity.status(HttpStatus.CREATED)
			.body("Customer ${customerRepository.save(customerDto.toEntity()).firstName} salvo com sucesso.")

	@GetMapping("/{id}")
	fun getById(@PathVariable id: Long): ResponseEntity<CustomerViewDto> =
		ResponseEntity.status(HttpStatus.OK).body(customerRepository.findById(id).get().run {
			CustomerViewDto(firstName, lastName, cpf, income, address.zipCode, address.street)
		})

	@DeleteMapping("/{id}")
	fun deleteById(@PathVariable id: Long) = customerRepository.deleteById(id)

	@PatchMapping("/{id}")
	fun updateCustomer(
		@PathVariable id: Long,
		@RequestBody customerToUpdateDto: CustomerToUpdateDto
	): ResponseEntity<CustomerViewDto> {
		val customer: Customer = customerRepository.findById(id).get()
		val updatedCustomer: Customer = customerToUpdateDto.toEntity(customer)
		return ResponseEntity.status(HttpStatus.OK).body(customerRepository.save(updatedCustomer).run {
			CustomerViewDto(firstName, lastName, cpf, income, address.zipCode, address.street)
		})
	}

}