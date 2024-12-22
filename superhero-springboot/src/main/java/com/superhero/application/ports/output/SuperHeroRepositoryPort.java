package com.superhero.application.ports.output;

import com.superhero.domain.model.SuperHero;

import java.util.List;
import java.util.Optional;

public interface SuperHeroRepositoryPort {
    SuperHero save(SuperHero superHero);
    Optional<SuperHero> findById(Long id);
    List<SuperHero> findAll();
    void deleteById(Long id);
}