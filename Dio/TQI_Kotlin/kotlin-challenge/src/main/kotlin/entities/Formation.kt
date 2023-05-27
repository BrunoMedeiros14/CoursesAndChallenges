package entities

data class Formation(
	val name: String,
) {
	private val contents: MutableSet<Content> = mutableSetOf<Content>()
	private val usersSubscribed: MutableSet<User> = mutableSetOf<User>()
	fun getTotalTime() = contents.map { content -> content.durationInMinutes }.reduce { acc, duration -> acc + duration }

	fun enrollUser(user: User): Boolean {
		usersSubscribed.add(user)
		user.formations.add(this)
		return true
	}

	fun addContent(content: Content): Boolean = this.contents.add(content)
	fun addContent(contents: Set<Content>): Boolean = this.contents.addAll(contents)

	override fun toString(): String {
		var str = "$name: \n contents:"
		if (contents.isNotEmpty()) contents.forEach { content -> str += "\n  $content" }
		else str += "empty"
		str += "\n users:"
		if (usersSubscribed.isNotEmpty()) usersSubscribed.forEach { user -> str += "\n  $user" }
		else str += "empty"
		return str
	}


}