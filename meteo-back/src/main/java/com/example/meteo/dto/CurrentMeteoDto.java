package com.example.meteo.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentMeteoDto {
        private String time;

        @JsonProperty("temperature_2m")
        private Double temperature;

        @JsonProperty("relative_humidity_2m")
        private Integer humidity;

        @JsonProperty("apparent_temperature")
        private Double apparentTemperature;

        private Double precipitation;

        @JsonProperty("wind_speed_10m")
        private Double windSpeed;

        @JsonProperty("weather_code")
        private Integer weatherCode;
    }
