package com.superhero.application.ports.input;

import com.superhero.domain.model.SuperHero;

import java.util.List;
import java.util.Optional;

public interface SuperHeroService {
    SuperHero createSuperHero(SuperHero superHero);
    Optional<SuperHero> getSuperHeroById(Long id);
    List<SuperHero> getAllSuperHeroes();
    void deleteSuperHeroById(Long id);
    SuperHero getSuperHeroByName(String name);
}