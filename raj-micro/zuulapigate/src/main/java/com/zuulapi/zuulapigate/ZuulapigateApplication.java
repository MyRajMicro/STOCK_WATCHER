package com.zuulapi.zuulapigate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

@EnableAutoConfiguration
@SpringBootApplication 
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulapigateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulapigateApplication.class, args);
		/* new SpringApplicationBuilder(
				 ZuulapigateApplication.class) 
		            .web(true).run(args);}*/
	}
}
