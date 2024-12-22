package com.superhero.infrastructure.client.impl;

import com.superhero.infrastructure.client.SuperHeroApiClient;
import com.superhero.infrastructure.dto.SuperHeroApiResponse;
import com.superhero.infrastructure.dto.SuperHeroDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SuperHeroApiClientImpl implements SuperHeroApiClient {

    @Value("${superhero.api.token}")
    private String apiToken;

    private final RestTemplate restTemplate;

    // Injection via le constructeur
    public SuperHeroApiClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SuperHeroDto getSuperHeroByName(String name) {
        String url = "https://superheroapi.com/api/" + apiToken + "/search/" + name;
        SuperHeroApiResponse response = restTemplate.getForObject(url, SuperHeroApiResponse.class);

        if (response != null && !response.getResults().isEmpty()) {
            return response.getResults().get(0); // Retourne le premier résultat
        }
        throw new RuntimeException("Super héros non trouvé : " + name);
    }
}