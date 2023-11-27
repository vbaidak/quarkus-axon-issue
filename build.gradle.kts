plugins {
	kotlin("jvm") apply false
}

subprojects {

	group = "io.github.vbaidak"
	version = "1.0.0"

	val quarkusPlatformGroupId: String by project
	val quarkusPlatformArtifactId: String by project
	val quarkusPlatformVersion: String by project

	tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
		kotlinOptions {
			jvmTarget = JavaVersion.VERSION_17.toString()
			javaParameters = true
		}
	}
	tasks.withType<Test> {
		systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
	}
}
