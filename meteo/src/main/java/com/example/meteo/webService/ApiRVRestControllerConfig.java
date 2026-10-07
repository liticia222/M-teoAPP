package com.example.meteo.webService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
@Configuration
public class ApiRVRestControllerConfig {

    @Bean(name = "restClient")
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("https://geocoding-api.open-meteo.com/v1")
                .build();
    }
    }

