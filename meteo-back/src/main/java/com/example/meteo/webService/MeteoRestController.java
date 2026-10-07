package com.example.meteo.webService;

import com.example.meteo.dto.MeteoResponseDto;
import com.example.meteo.service.MeteoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/meteo")
@CrossOrigin
public class MeteoRestController {
    private MeteoService meteoService;
    public MeteoRestController( MeteoService meteoService) {
        this.meteoService = meteoService;
    }

    @GetMapping("/forecast")
    public MeteoResponseDto getWeatherForecast(@RequestParam double latitude, @RequestParam double longitude) {
        return meteoService.obtenirMeteo(latitude, longitude);
    }

}