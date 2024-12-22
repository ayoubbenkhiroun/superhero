package com.superhero.domain.model;

import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Represents a superhero")
public class SuperHero {

    @Schema(description = "Unique identifier of the superhero", example = "1")
    private Long id;

    @Schema(description = "Name of the superhero", example = "Spiderman")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Schema(description = "Alias of the superhero", example = "Peter Parker")
    @NotBlank(message = "Alias is mandatory")
    @Size(min = 2, max = 100, message = "Alias must be between 2 and 100 characters")
    private String alias;

    @Schema(description = "List of powers of the superhero")
    @NotNull(message = "Powers cannot be null")
    private Set<Power> powers;

    @Schema(description = "List of abilities of the superhero")
    @NotNull(message = "Abilities cannot be null")
    private Set<Ability> abilities;

    @Schema(description = "List of magical abilities of the superhero")
    @NotNull(message = "MagicalAbilities cannot be null")
    private Set<MagicalAbility> magicalAbilities;

    // Constructeur par défaut
    public SuperHero() {
    }

    // Constructeur avec tous les champs
    public SuperHero(Long id, String name, String alias, Set<Power> powers, Set<Ability> abilities, Set<MagicalAbility> magicalAbilities) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.powers = powers;
        this.abilities = abilities;
        this.magicalAbilities = magicalAbilities;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Set<Power> getPowers() {
        return powers;
    }

    public void setPowers(Set<Power> powers) {
        this.powers = powers;
    }

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(Set<Ability> abilities) {
        this.abilities = abilities;
    }

    public Set<MagicalAbility> getMagicalAbilities() {
        return magicalAbilities;
    }

    public void setMagicalAbilities(Set<MagicalAbility> magicalAbilities) {
        this.magicalAbilities = magicalAbilities;
    }

    // Méthode toString pour le débogage
    @Override
    public String toString() {
        return "SuperHero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", powers=" + powers +
                ", abilities=" + abilities +
                ", magicalAbilities=" + magicalAbilities +
                '}';
    }
}