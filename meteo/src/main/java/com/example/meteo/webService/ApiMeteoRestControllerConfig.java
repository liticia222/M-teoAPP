package com.example.meteo.webService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
@Configuration
public class ApiMeteoRestControllerConfig {

    @Bean(name = "restClient2")
    public RestClient restClient2() {
        return RestClient.builder()
                .baseUrl("https://api.open-meteo.com/v1")
                .build();
    }
}
