package com.superhero.infrastructure.persistence;

import com.superhero.application.ports.output.SuperHeroRepositoryPort;
import com.superhero.domain.model.Ability;
import com.superhero.domain.model.MagicalAbility;
import com.superhero.domain.model.Power;
import com.superhero.domain.model.SuperHero;
import com.superhero.infrastructure.persistence.entity.SuperHeroEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SuperHeroRepositoryAdapter implements SuperHeroRepositoryPort {

    private final SuperHeroJpaRepository superHeroJpaRepository;

    public SuperHeroRepositoryAdapter(SuperHeroJpaRepository superHeroJpaRepository) {
        this.superHeroJpaRepository = superHeroJpaRepository;
    }

    @Override
    public SuperHero save(SuperHero superHero) {
        SuperHeroEntity entity = mapToEntity(superHero);
        SuperHeroEntity savedEntity = superHeroJpaRepository.save(entity);
        return mapToDomain(savedEntity);
    }

    @Override
    public Optional<SuperHero> findById(Long id) {
        return superHeroJpaRepository.findById(id).map(this::mapToDomain);
    }

    @Override
    public List<SuperHero> findAll() {
        return superHeroJpaRepository.findAll().stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        superHeroJpaRepository.deleteById(id);
    }

    // Méthode pour convertir un SuperHero en SuperHeroEntity
    private SuperHeroEntity mapToEntity(SuperHero superHero) {
        // Initialiser les champs null avec des ensembles vides
        Set<Power> powers = superHero.getPowers() != null ? superHero.getPowers() : Collections.emptySet();
        Set<Ability> abilities = superHero.getAbilities() != null ? superHero.getAbilities() : Collections.emptySet();
        Set<MagicalAbility> magicalAbilities = superHero.getMagicalAbilities() != null ? superHero.getMagicalAbilities() : Collections.emptySet();

        return new SuperHeroEntity(
                superHero.getId(),
                superHero.getName(),
                superHero.getAlias(),
                powers.stream().map(power -> new com.superhero.infrastructure.persistence.entity.PowerEntity(
                        power.getId(),
                        power.getName(),
                        power.getDescription()
                )).collect(Collectors.toSet()),
                abilities.stream().map(ability -> new com.superhero.infrastructure.persistence.entity.AbilityEntity(
                        ability.getId(),
                        ability.getName(),
                        ability.getDescription()
                )).collect(Collectors.toSet()),
                magicalAbilities.stream().map(magicalAbility -> new com.superhero.infrastructure.persistence.entity.MagicalAbilityEntity(
                        magicalAbility.getId(),
                        magicalAbility.getName(),
                        magicalAbility.getDescription()
                )).collect(Collectors.toSet())
        );
    }

    // Méthode pour convertir un SuperHeroEntity en SuperHero
    private SuperHero mapToDomain(SuperHeroEntity entity) {
        return new SuperHero(
                entity.getId(),
                entity.getName(),
                entity.getAlias(),
                entity.getPowers().stream().map(powerEntity -> new com.superhero.domain.model.Power(
                        powerEntity.getId(),
                        powerEntity.getName(),
                        powerEntity.getDescription()
                )).collect(Collectors.toSet()),
                entity.getAbilities().stream().map(abilityEntity -> new com.superhero.domain.model.Ability(
                        abilityEntity.getId(),
                        abilityEntity.getName(),
                        abilityEntity.getDescription()
                )).collect(Collectors.toSet()),
                entity.getMagicalAbilities().stream().map(magicalAbilityEntity -> new com.superhero.domain.model.MagicalAbility(
                        magicalAbilityEntity.getId(),
                        magicalAbilityEntity.getName(),
                        magicalAbilityEntity.getDescription()
                )).collect(Collectors.toSet())
        );
    }
}