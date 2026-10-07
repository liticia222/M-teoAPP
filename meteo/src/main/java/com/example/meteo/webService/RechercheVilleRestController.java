package com.example.meteo.webService;


import com.example.meteo.dto.ResponseDto;
import com.example.meteo.dto.ResultSearchDto;
import com.example.meteo.service.RechercheVilleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequestMapping("/meteo")
@CrossOrigin
@RestController
public class RechercheVilleRestController {
    private  RechercheVilleService rechercheVilleService;
    public RechercheVilleRestController(RechercheVilleService rechercheVilleService) {
        this.rechercheVilleService = rechercheVilleService;
    }
    @GetMapping("/search")
    public List<ResultSearchDto> searchCity(@RequestParam String name) {
        return rechercheVilleService.rechercherVille(name);
    }
}





