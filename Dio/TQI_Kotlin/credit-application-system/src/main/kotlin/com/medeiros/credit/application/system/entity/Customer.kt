package com.medeiros.credit.application.system.entity

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.math.BigDecimal

@Entity
@Table(name = "tbl_customer")
class Customer(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null,
	@Column(nullable = false)
	var firstName: String,
	@Column(nullable = false)
	var lastName: String,
	@Column(nullable = false, unique = true)
	val cpf: String,
	@Column(nullable = false, unique = true)
	var email: String,
	@Column(nullable = false)
	var income: BigDecimal,
	@Column(nullable = false)
	var password: String,
	@Embedded
	@Column(nullable = false)
	var address: Address = Address(),
	@OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE, CascadeType.PERSIST], mappedBy = "customer")
	@Column(nullable = false)
	var credits: List<Credit> = mutableListOf()
) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
		other as Customer

		return id != null && id == other.id
	}

	override fun hashCode(): Int = javaClass.hashCode()
}