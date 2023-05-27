import entities.Content
import entities.Formation
import entities.User
import enums.Difficulty
import enums.Gender

fun main() {

	println("Generating content to formation...")
	val java = Content("Java", 120, "Aprenda a desenvolver em Java", Difficulty.HARD)
	val kotlin = Content("Kotlin", 60, "Aprenda a desenvolver em Kotlin", Difficulty.MEDIUM)
	val backendContents = setOf<Content>(java, kotlin)

	println("Generating content to formation 2...")
	val javaScript = Content("javaScript", 60, "Aprenda a desenvolver em javaScript", Difficulty.MEDIUM)
	val css = Content("CSS", 40, "Aprenda a desenvolver em CSS", Difficulty.EASY)
	val frontendContents = setOf<Content>(javaScript, css)

	println("Generating user...")
	val bruno = User("Bruno", 22, Gender.M, mutableSetOf<Formation>())



	println("Generating formation and adding content...")
	val backendFormation = Formation("Back-end")
	backendFormation.addContent(backendContents)

	println("Generating formation 2 and adding content...")
	val frontendFormation = Formation("Front-end")
	frontendFormation.addContent(frontendContents)

	println("Enroll user to formation...")
	frontendFormation.enrollUser(bruno)
	backendFormation.enrollUser(bruno)

	print("\nUser formations: ")
	println(bruno.getEnrolledFormations())
	print("Total time backend formation: ")
	println(backendFormation.getTotalTime())
	print("Total time frontend formation: ")
	println(frontendFormation.getTotalTime())
	println("\nPrint backend formation info")
	println(backendFormation)
	println("\nPrint frontend formation info")
	println(frontendFormation)


}