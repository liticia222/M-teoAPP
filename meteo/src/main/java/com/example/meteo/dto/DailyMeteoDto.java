package com.example.meteo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyMeteoDto {
    private List<String> time;

    @JsonProperty("weather_code")
        private List<Integer> weatherCode;

        @JsonProperty("temperature_2m_max")
        private List<Double> temperatureMax;

        @JsonProperty("temperature_2m_min")
        private List<Double> temperatureMin;

        @JsonProperty("precipitation_probability_max")
        private List<Integer> precipitationProbabilityMax;
    }
