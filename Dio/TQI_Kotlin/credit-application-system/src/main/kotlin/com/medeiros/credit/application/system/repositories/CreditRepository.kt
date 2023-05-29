package com.medeiros.credit.application.system.repositories

import com.medeiros.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository : JpaRepository<Credit, Long>