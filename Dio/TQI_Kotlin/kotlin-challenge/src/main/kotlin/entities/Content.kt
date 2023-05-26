package entities

import enums.Difficulty

data class Content(
	val name: String,
	val durationInMinutes: Int,
	val description: String,
	val level: Difficulty
)