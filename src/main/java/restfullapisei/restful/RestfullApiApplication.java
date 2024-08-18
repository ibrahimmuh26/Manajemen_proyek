package restfullapisei.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestfullApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfullApiApplication.class, args);
	}

	public
	ConfigurableWebServerFactory webServerFactory() {
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.setPort(9000);

		return factory;

	}
}
