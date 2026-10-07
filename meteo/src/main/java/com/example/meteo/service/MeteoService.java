package com.example.meteo.service;

import com.example.meteo.dto.MeteoResponseDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClient;
@Service
public class MeteoService {

    private RestClient restClient;
    public MeteoService(@Qualifier("restClient2") RestClient restClient) {
        this.restClient = restClient;
    }
    public MeteoResponseDto obtenirMeteo(double latitude, double longitude) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/forecast")
                        .queryParam("latitude", latitude)
                        .queryParam("longitude", longitude)
                        .queryParam("current", "temperature_2m,relative_humidity_2m,apparent_temperature,precipitation,wind_speed_10m,weather_code")
                        .queryParam("daily", "weather_code,temperature_2m_max,temperature_2m_min,precipitation_probability_max")
                        .queryParam("timezone", "auto")
                        .build())
                .retrieve()
                .body(MeteoResponseDto.class);
    }

}
