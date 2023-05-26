package entities

import enums.Gender

data class User(
	var name: String,
	var age: Int,
	var gender: Gender,
	var formations: MutableSet<Formation>
)