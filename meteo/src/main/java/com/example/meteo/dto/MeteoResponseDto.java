package com.example.meteo.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeteoResponseDto {
        private Double latitude;
        private Double longitude;
        private String timezone;
        private CurrentMeteoDto current;
        private DailyMeteoDto daily;
    }

