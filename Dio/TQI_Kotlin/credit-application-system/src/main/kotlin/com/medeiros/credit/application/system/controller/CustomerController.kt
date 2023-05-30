package com.medeiros.credit.application.system.controller

import com.medeiros.credit.application.system.dto.CustomerDto
import com.medeiros.credit.application.system.dto.CustomerToUpdateDto
import com.medeiros.credit.application.system.dto.CustomerViewDto
import com.medeiros.credit.application.system.entity.Customer
import com.medeiros.credit.application.system.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
	private val customerService: CustomerService
) {

	@GetMapping
	fun getAllCustomer(): ResponseEntity<List<CustomerViewDto>> =
		ResponseEntity.status(HttpStatus.OK).body(customerService.findAll().map {
			it.run { CustomerViewDto(firstName, lastName, cpf, income, address.zipCode, address.street) }
		})

	@PostMapping
	fun saveCustomer(@RequestBody customerDto: CustomerDto): ResponseEntity<String> =
		ResponseEntity.status(HttpStatus.CREATED)
			.body("Customer ${customerService.save(customerDto.toEntity()).firstName} salvo com sucesso.")

	@GetMapping("/{id}")
	fun getById(@PathVariable id: Long): ResponseEntity<CustomerViewDto> =
		ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id).run {
			CustomerViewDto(firstName, lastName, cpf, income, address.zipCode, address.street)
		})

	@DeleteMapping("/{id}")
	fun deleteById(@PathVariable id: Long) = customerService.delete(id)

	@PatchMapping("/{id}")
	fun updateCustomer(
		@PathVariable id: Long,
		@RequestBody customerToUpdateDto: CustomerToUpdateDto
	): ResponseEntity<CustomerViewDto> {
		val customer: Customer = customerService.findById(id)
		val updatedCustomer: Customer = customerToUpdateDto.toEntity(customer)
		return ResponseEntity.status(HttpStatus.OK).body(customerService.save(updatedCustomer).run {
			CustomerViewDto(firstName, lastName, cpf, income, address.zipCode, address.street)
		})
	}

}