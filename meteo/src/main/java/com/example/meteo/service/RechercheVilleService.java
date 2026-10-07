package com.example.meteo.service;

import com.example.meteo.dto.ResultSearchDto;
import com.example.meteo.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RechercheVilleService {

    private RestClient restClient;
    public RechercheVilleService(@Qualifier("restClient") RestClient restClient) {
        this.restClient = restClient;
    }
    public List<ResultSearchDto> rechercherVille(String name) {
        ResponseDto response = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("name", name)
                        .queryParam("count", 5)
                        .queryParam("language", "fr")
                        .queryParam("format", "json")
                        .build())
                .retrieve()
                .body(ResponseDto.class);

        if (response != null && response.getResults() != null) {
            return response.getResults();
        }

        return List.of();
    }
}
