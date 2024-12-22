package com.superhero.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AppearanceDto {

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("race")
    private String race;

    @JsonProperty("height")
    private List<String> height;

    @JsonProperty("weight")
    private List<String> weight;

    @JsonProperty("eye-color")
    private String eyeColor;

    @JsonProperty("hair-color")
    private String hairColor;

    // Getters et Setters
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public List<String> getHeight() {
        return height;
    }

    public void setHeight(List<String> height) {
        this.height = height;
    }

    public List<String> getWeight() {
        return weight;
    }

    public void setWeight(List<String> weight) {
        this.weight = weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
}