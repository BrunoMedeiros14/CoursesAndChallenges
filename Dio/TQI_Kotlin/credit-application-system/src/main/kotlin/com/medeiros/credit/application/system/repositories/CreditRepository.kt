package com.medeiros.credit.application.system.repositories

import com.medeiros.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CreditRepository : JpaRepository<Credit, Long> {
	fun findByCreditCode(creditCode: UUID): Credit?

	@Query(value = "SELECT * FROM tbl_credit WHERE customer_id = :customer_id", nativeQuery = true)
	fun findAllByCustomerId(@Param("customer_id") customerId: Long): List<Credit>
}