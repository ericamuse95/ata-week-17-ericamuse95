package com.kenzie.videocontentservice.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShowResponse {
    @JsonProperty("showId")
    private String id;
    @JsonProperty("title")
    private String title;

    @JsonProperty("parentalGuideline")
    private String parentalGuideline;

    @JsonProperty("episodeLength")
    private int episodeLength;

    @JsonProperty("genre")
    private String genre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParentalGuideline() {
        return parentalGuideline;
    }

    public void setParentalGuideline(String parentalGuideline) {
        this.parentalGuideline = parentalGuideline;
    }

    public int getEpisodeLength() {
        return episodeLength;
    }

    public void setEpisodeLength(int episodeLength) {
        this.episodeLength = episodeLength;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}