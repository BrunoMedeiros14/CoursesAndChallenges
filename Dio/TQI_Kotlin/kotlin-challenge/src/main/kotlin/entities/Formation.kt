package entities

data class Formation(
	val name: String,
	val contents: MutableSet<Content>,
	val usersSubscribed: MutableSet<User>
) {
	fun getTotalTime() = contents.map { content -> content.durationInMinutes }.reduce { acc, duration -> acc + duration }
}