package axonframework

import io.quarkus.runtime.Shutdown
import io.quarkus.runtime.Startup
import jakarta.enterprise.context.ApplicationScoped
import org.axonframework.config.Configuration

/**
 * @author shell
 * @since 2023-11-20
 */
@ApplicationScoped
class AxonBootstrapper(private val configuration: Configuration) {

	@Startup
	fun startup() {
		configuration.start()
	}

	@Shutdown
	fun shutdown() {
		configuration.shutdown()
	}

}
