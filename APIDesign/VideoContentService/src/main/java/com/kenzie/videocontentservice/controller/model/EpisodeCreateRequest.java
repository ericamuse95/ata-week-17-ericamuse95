package com.kenzie.videocontentservice.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class EpisodeCreateRequest {
    @NotEmpty
    @JsonProperty("showId")
    private String showId;

    @JsonProperty("seasonNumber")
    private int seasonNumber;

    @Min(0)
    @JsonProperty("episodeNumber")
    private int episodeNumber;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("averageRating")
    private double averageRating;

    @JsonProperty("numberOfRatings")
    private int numberOfRatings;

    @JsonProperty("aired")
    private Date aired;


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
