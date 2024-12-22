package com.superhero.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkDto {

    @JsonProperty("occupation")
    private String occupation;

    @JsonProperty("base")
    private String base;

    // Getters et Setters
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}