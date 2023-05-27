package entities

import enums.Gender

data class User(
	var name: String,
	var age: Int,
	var gender: Gender,
	var formations: MutableSet<Formation>
){
	fun getEnrolledFormations() =
		formations.map{ formation -> formation.name }

	override fun toString(): String {
		return "$name:{age=$age, gender=$gender}"
	}

}