package com.medeiros.credit.application.system.repositories

import com.medeiros.credit.application.system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long>