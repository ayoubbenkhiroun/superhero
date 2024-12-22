package com.superhero.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectionsDto {

    @JsonProperty("group-affiliation")
    private String groupAffiliation;

    @JsonProperty("relatives")
    private String relatives;

    // Getters et Setters
    public String getGroupAffiliation() {
        return groupAffiliation;
    }

    public void setGroupAffiliation(String groupAffiliation) {
        this.groupAffiliation = groupAffiliation;
    }

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }
}