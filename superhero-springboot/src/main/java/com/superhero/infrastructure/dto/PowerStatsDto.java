package com.superhero.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PowerStatsDto {

    @JsonProperty("intelligence")
    private String intelligence;

    @JsonProperty("strength")
    private String strength;

    @JsonProperty("speed")
    private String speed;

    @JsonProperty("durability")
    private String durability;

    @JsonProperty("power")
    private String power;

    @JsonProperty("combat")
    private String combat;

    // Getters et Setters
    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCombat() {
        return combat;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }
}