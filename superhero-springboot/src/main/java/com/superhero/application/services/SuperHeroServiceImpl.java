package com.superhero.application.services;

import com.superhero.application.ports.input.SuperHeroService;
import com.superhero.application.ports.output.SuperHeroRepositoryPort;
import com.superhero.domain.model.SuperHero;
import com.superhero.infrastructure.client.SuperHeroApiClient;
import com.superhero.infrastructure.dto.SuperHeroDto;
import com.superhero.infrastructure.mapper.SuperHeroMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    private final SuperHeroRepositoryPort superHeroRepositoryPort;
    private final SuperHeroApiClient superHeroApiClient;


    public SuperHeroServiceImpl(SuperHeroRepositoryPort superHeroRepositoryPort, SuperHeroApiClient superHeroApiClient) {
        this.superHeroRepositoryPort = superHeroRepositoryPort;
        this.superHeroApiClient = superHeroApiClient;
    }

    @Override
    public SuperHero createSuperHero(SuperHero superHero) {
        return superHeroRepositoryPort.save(superHero);
    }

    @Override
    public Optional<SuperHero> getSuperHeroById(Long id) {
        return superHeroRepositoryPort.findById(id);
    }

    @Override
    public List<SuperHero> getAllSuperHeroes() {
        return superHeroRepositoryPort.findAll();
    }

    @Override
    public void deleteSuperHeroById(Long id) {
        superHeroRepositoryPort.deleteById(id);
    }

    @Override
    public SuperHero getSuperHeroByName(String name) {
        // Appeler l'API externe via le port
        SuperHeroDto dto = superHeroApiClient.getSuperHeroByName(name);

        // Mapper le DTO vers l'entité de domaine
        SuperHero domainSuperHero = SuperHeroMapper.INSTANCE.dtoToDomain(dto);

        // Mapper les collections manuellement
        domainSuperHero.setPowers(SuperHeroMapper.INSTANCE.mapPowers(dto.getPowerstats()));
        domainSuperHero.setAbilities(SuperHeroMapper.INSTANCE.mapAbilities(dto.getWork()));
        domainSuperHero.setMagicalAbilities(SuperHeroMapper.INSTANCE.mapMagicalAbilities(dto.getBiography()));

        return domainSuperHero;
    }

}