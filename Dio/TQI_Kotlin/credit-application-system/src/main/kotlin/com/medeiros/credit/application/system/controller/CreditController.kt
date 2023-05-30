package com.medeiros.credit.application.system.controller

import com.medeiros.credit.application.system.dto.CreditDto
import com.medeiros.credit.application.system.dto.CreditView
import com.medeiros.credit.application.system.dto.CreditViewList
import com.medeiros.credit.application.system.entity.Credit
import com.medeiros.credit.application.system.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/credits")
class CreditController(
	private val creditService: CreditService
) {

	@PostMapping
	fun saveCredit(@RequestBody creditDto: CreditDto): ResponseEntity<String> {
		val credit: Credit = this.creditService.save(creditDto.toEntity())
		return ResponseEntity.status(HttpStatus.CREATED)
			.body("Credit ${credit.creditCode} - Customer ${credit.customer?.email} saved!")
	}

	@GetMapping
	fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>> =
		ResponseEntity.status(HttpStatus.OK).body(creditService.findAllByCustomer(customerId).map { credit: Credit ->
			credit.run {
				CreditViewList(creditCode, creditValue, numberOfInstallments)
			}
		})

	@GetMapping("/{creditCode}")
	fun findByCreditCode(
		@RequestParam(value = "customerId") customerId: Long, @PathVariable creditCode: UUID
	): ResponseEntity<CreditView> =
		ResponseEntity.status(HttpStatus.OK).body(creditService.findByCreditCode(customerId, creditCode).run {
			CreditView(creditCode, creditValue, numberOfInstallments, status, customer?.email, customer?.income)
		})
}
