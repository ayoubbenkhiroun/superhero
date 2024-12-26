package com.superhero.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageDto {

    @JsonProperty("url")
    private String url;

    // Getters et Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}