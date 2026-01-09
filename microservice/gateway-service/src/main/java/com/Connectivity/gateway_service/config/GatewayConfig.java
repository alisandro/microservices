package com.Connectivity.gateway_service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-management-route", r -> r.path("/orders/**")
                        .filters(f -> f.addRequestHeader("X-Gateway-Custom-Header", "Gateway-Value"))
                        .uri("http://localhost:8080"))
                .route("customer-service-route", r -> r.path("/customers/**")
                        .uri("http://localhost:8081"))
                .build();
    }
}