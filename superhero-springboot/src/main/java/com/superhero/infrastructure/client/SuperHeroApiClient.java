package com.superhero.infrastructure.client;

import com.superhero.infrastructure.dto.SuperHeroDto;

public interface SuperHeroApiClient {
    SuperHeroDto getSuperHeroByName(String name);
}