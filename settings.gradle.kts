rootProject.name = "quarkus-axon-issue"

include("quarkus-axon-issue")

pluginManagement {
	val kotlinVersion: String by settings
	val quarkusPluginVersion: String by settings
	val quarkusPluginId: String by settings

	plugins {
		kotlin("jvm") version kotlinVersion
		kotlin("plugin.allopen") version kotlinVersion
		id(quarkusPluginId) version quarkusPluginVersion
	}
}
