package com.mohammali.poc.eventsourcing.axongateway;

import org.axonframework.spring.stereotype.Saga;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@EntityScan(basePackages = {"com.mohammali.poc.eventsourcing",
	"org.axonframework.eventsourcing.eventstore.jpa",
	"org.axonframework.eventhandling.saga.repository.jpa",
	"org.axonframework.eventhandling.tokenstore.jpa"})
@EnableJpaRepositories(basePackages = {"com.mohammali.poc.eventsourcing"})*/
@Saga
public class AxonGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxonGatewayApplication.class, args);
	}

}
