package br.edu.infnet.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class GatewayApplication {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		return builder.routes()
				.route(p -> p
						.path("/clientes/**")
						.uri("http://localhost:8082"))
				.route(p -> p
						.path("/equipamentos/**")
						.filters(f -> f.circuitBreaker(config -> config
								.setName("mycmd")
								.setFallbackUri("forward:/fallback"))
						)
						.uri("http://localhost:8083"))
				.build();
	}

	@RequestMapping("/fallback")
	public String fallback(){
		return "Sinto Muito... Tente novamente!";
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
