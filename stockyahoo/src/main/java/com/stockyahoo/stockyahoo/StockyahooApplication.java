package com.stockyahoo.stockyahoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
@EnableAutoConfiguration
@EnableEurekaClient
@ComponentScan("com.stockyahoo")
@SpringBootApplication
public class StockyahooApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockyahooApplication.class, args);
	}
}
