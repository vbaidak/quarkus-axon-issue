package axonframework

import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Instance
import jakarta.enterprise.inject.build.compatible.spi.*
import org.axonframework.config.Configuration
import org.axonframework.config.DefaultConfigurer

/**
 * @author shell
 * @since 2023-11-20
 */
class AxonExtension : BuildCompatibleExtension {

	@Synthesis
	fun synthesis(syntheticComponents: SyntheticComponents) {
		val type = Configuration::class.java
		syntheticComponents.addBean(type)
			.type(type)
			.scope(ApplicationScoped::class.java)
			.createWith(AxonConfigurationSyntheticBeanCreator::class.java)
	}

	open class AxonConfigurationSyntheticBeanCreator : SyntheticBeanCreator<Configuration> {
		override fun create(lookup: Instance<Any>, params: Parameters): Configuration {
			return DefaultConfigurer.defaultConfiguration().buildConfiguration()
		}
	}

}
