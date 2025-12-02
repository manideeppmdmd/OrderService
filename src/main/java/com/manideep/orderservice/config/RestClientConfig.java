package com.manideep.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

  @Bean
  @LoadBalanced
  RestClient.Builder restClientBuilder() {
    return RestClient.builder();
  }
}
//Adding loadBalance on a RestTemplate enables client-side load balancing
//It intercept the local service and resolve them into actual instances URLS from Eureka
