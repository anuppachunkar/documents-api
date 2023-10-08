package com.qdb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.qdb.controller", "com.qdb.service"})
@EntityScan("com.qdb.entity")
@EnableJpaRepositories("com.qdb.repository")
@EnableFeignClients("com.qdb.feignclients")

public class DocmentServiceApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(DocmentServiceApplication.class, args);
	}
}
