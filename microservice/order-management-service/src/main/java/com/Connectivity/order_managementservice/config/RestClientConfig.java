package com.Connectivity.order_managementservice.config;

import com.Connectivity.order_managementservice.exceptions.RestTemplateErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
@Configuration
public class RestClientConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder, RestTemplateErrorHandler errorHandler) {
        return builder
                .setConnectTimeout(Duration.ofMillis(2000))
                .setReadTimeout(Duration.ofMillis(3000))
                .errorHandler(errorHandler) // <--- Conectamos el manejador
                .build();
    }
}
