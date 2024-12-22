package com.superhero.infrastructure.mapper;

import com.superhero.domain.model.Ability;
import com.superhero.domain.model.MagicalAbility;
import com.superhero.domain.model.Power;
import com.superhero.domain.model.SuperHero;
import com.superhero.infrastructure.dto.BiographyDto;
import com.superhero.infrastructure.dto.PowerStatsDto;
import com.superhero.infrastructure.dto.SuperHeroDto;
import com.superhero.infrastructure.dto.WorkDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

@Mapper
public interface SuperHeroMapper {

    SuperHeroMapper INSTANCE = Mappers.getMapper(SuperHeroMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "biography.fullName", target = "alias")
    @Mapping(target = "id", ignore = true) // L'ID est géré localement, pas besoin de le mapper
    @Mapping(target = "powers", ignore = true) // Nous allons mapper les pouvoirs manuellement
    @Mapping(target = "abilities", ignore = true) // Nous allons mapper les compétences manuellement
    @Mapping(target = "magicalAbilities", ignore = true) // Nous allons mapper les capacités magiques manuellement
    SuperHero dtoToDomain(SuperHeroDto dto);

    default Set<Power> mapPowers(PowerStatsDto powerStats) {
        // Convertir les statistiques de pouvoir en objets Power
        Set<Power> powers = new HashSet<>();
        if (powerStats != null) {
            powers.add(new Power(null, "Intelligence", powerStats.getIntelligence()));
            powers.add(new Power(null, "Strength", powerStats.getStrength()));
            powers.add(new Power(null, "Speed", powerStats.getSpeed()));
            powers.add(new Power(null, "Durability", powerStats.getDurability()));
            powers.add(new Power(null, "Power", powerStats.getPower()));
            powers.add(new Power(null, "Combat", powerStats.getCombat()));
        }
        return powers;
    }

    default Set<Ability> mapAbilities(WorkDto work) {
        // Convertir les compétences en objets Ability
        Set<Ability> abilities = new HashSet<>();
        if (work != null && work.getOccupation() != null) {
            abilities.add(new Ability(null, "Occupation", work.getOccupation()));
        }
        return abilities;
    }

    default Set<MagicalAbility> mapMagicalAbilities(BiographyDto biography) {
        // Convertir les capacités magiques en objets MagicalAbility
        Set<MagicalAbility> magicalAbilities = new HashSet<>();
        if (biography != null && biography.getAliases() != null) {
            for (String alias : biography.getAliases()) {
                magicalAbilities.add(new MagicalAbility(null, "Alias", alias));
            }
        }
        return magicalAbilities;
    }
}