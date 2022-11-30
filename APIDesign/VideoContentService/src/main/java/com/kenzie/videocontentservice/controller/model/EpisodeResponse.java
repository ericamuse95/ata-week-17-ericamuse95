package com.kenzie.videocontentservice.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class EpisodeResponse {
    @JsonProperty("showId")
    private String showId;
    @JsonProperty("seasonNumber")
    private int seasonNumber;

    @JsonProperty("episodeNumber")
    private int episodeNumber;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

