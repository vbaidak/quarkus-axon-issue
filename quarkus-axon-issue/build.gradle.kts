plugins {
	kotlin("jvm")
	kotlin("plugin.allopen")

	id("io.quarkus")
}

allOpen {
	annotation("jakarta.enterprise.context.ApplicationScoped")
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
	implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
	implementation("io.quarkus:quarkus-config-yaml")
	implementation("io.quarkus:quarkus-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("io.quarkus:quarkus-arc")

	implementation("org.axonframework:axon-configuration:4.8.3")
}
