package com.kenzie.videocontentservice.controller.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class GetEpisodeResponse {
    @JsonProperty("showId")
    private String showId;
    @JsonProperty("seasonNumber")
    private int seasonNumber;

    @JsonProperty("episodeNumber")
    private int episodeNumber;

    @JsonProperty("title")
    private String title;

    @JsonProperty("averageRating")
    private Double averageRating;

    @JsonProperty("numberOfRatings")
    private int numberOfRatings;

    @JsonProperty("aired")
    private Date aired;

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

    public Double getAverageRating(){return averageRating;}

    public void setAverageRating(Double averageRating){this.averageRating = averageRating;}

    public int getNumberOfRatings(){return numberOfRatings;}

    public void setNumberOfRatings(int numberOfRatings){this.numberOfRatings = numberOfRatings;}

    public Date getAired(){return aired;}

    public void setAired(Date aired){this.aired = aired;}

}


