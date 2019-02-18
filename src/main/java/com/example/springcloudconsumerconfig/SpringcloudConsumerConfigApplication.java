package com.example.springcloudconsumerconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "springcloud-provider-config")
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION)})
@EnableHystrix
@EnableSwagger2
public class SpringcloudConsumerConfigApplication {
	@Autowired
    private RestTemplateBuilder builder;
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConsumerConfigApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return builder.build();
	}

}

