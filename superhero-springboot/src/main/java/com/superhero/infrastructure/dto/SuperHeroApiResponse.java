package com.superhero.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SuperHeroApiResponse {

    @JsonProperty("response")
    private String response;

    @JsonProperty("results-for")
    private String resultsFor;

    @JsonProperty("results")
    private List<SuperHeroDto> results;

    // Getters et Setters
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResultsFor() {
        return resultsFor;
    }

    public void setResultsFor(String resultsFor) {
        this.resultsFor = resultsFor;
    }

    public List<SuperHeroDto> getResults() {
        return results;
    }

    public void setResults(List<SuperHeroDto> results) {
        this.results = results;
    }
}