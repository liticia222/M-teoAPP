package com.example.meteo;

import com.example.meteo.webService.ApiMeteoRestControllerConfig;
import com.example.meteo.webService.ApiRVRestControllerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeteoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeteoApplication.class, args);
    }

}
