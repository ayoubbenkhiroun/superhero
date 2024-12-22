package com.superhero.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuperHeroDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("powerstats")
    private PowerStatsDto powerstats;

    @JsonProperty("biography")
    private BiographyDto biography;

    @JsonProperty("appearance")
    private AppearanceDto appearance;

    @JsonProperty("work")
    private WorkDto work;

    @JsonProperty("connections")
    private ConnectionsDto connections;

    @JsonProperty("image")
    private ImageDto image;

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PowerStatsDto getPowerstats() {
        return powerstats;
    }

    public void setPowerstats(PowerStatsDto powerstats) {
        this.powerstats = powerstats;
    }

    public BiographyDto getBiography() {
        return biography;
    }

    public void setBiography(BiographyDto biography) {
        this.biography = biography;
    }

    public AppearanceDto getAppearance() {
        return appearance;
    }

    public void setAppearance(AppearanceDto appearance) {
        this.appearance = appearance;
    }

    public WorkDto getWork() {
        return work;
    }

    public void setWork(WorkDto work) {
        this.work = work;
    }

    public ConnectionsDto getConnections() {
        return connections;
    }

    public void setConnections(ConnectionsDto connections) {
        this.connections = connections;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }
}