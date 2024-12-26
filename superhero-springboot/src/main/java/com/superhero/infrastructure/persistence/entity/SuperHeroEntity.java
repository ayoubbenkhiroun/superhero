package com.superhero.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class SuperHeroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String alias;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PowerEntity> powers;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AbilityEntity> abilities;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<MagicalAbilityEntity> magicalAbilities;

    // Constructeur par défaut
    public SuperHeroEntity() {
    }

    // Constructeur avec tous les champs
    public SuperHeroEntity(Long id, String name, String alias, Set<PowerEntity> powers, Set<AbilityEntity> abilities, Set<MagicalAbilityEntity> magicalAbilities) {
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

    public Set<PowerEntity> getPowers() {
        return powers;
    }

    public void setPowers(Set<PowerEntity> powers) {
        this.powers = powers;
    }

    public Set<AbilityEntity> getAbilities() {
        return abilities;
    }

    public void setAbilities(Set<AbilityEntity> abilities) {
        this.abilities = abilities;
    }

    public Set<MagicalAbilityEntity> getMagicalAbilities() {
        return magicalAbilities;
    }

    public void setMagicalAbilities(Set<MagicalAbilityEntity> magicalAbilities) {
        this.magicalAbilities = magicalAbilities;
    }

    // Méthode toString pour le débogage
    @Override
    public String toString() {
        return "SuperHeroEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", powers=" + powers +
                ", abilities=" + abilities +
                ", magicalAbilities=" + magicalAbilities +
                '}';
    }
}