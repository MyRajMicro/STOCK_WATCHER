package com.dbclient.dbclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.db.stock.dbservice.model")
@ComponentScan("com.db.stock.dbservice")
@EnableJpaRepositories(basePackages="com.db.stock.dbservice.repository")
@EnableDiscoveryClient
public class DbclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbclientApplication.class, args);
	}
}
