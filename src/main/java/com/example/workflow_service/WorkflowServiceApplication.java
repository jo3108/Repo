package com.example.workflow_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WorkflowServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(WorkflowServiceApplication.class, args);

		Mono<String> mono = Mono.just("john");
		Flux<String> flux =Flux.just("Hello,Stream,hell");

	}

}
