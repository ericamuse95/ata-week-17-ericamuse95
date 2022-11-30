package com.kenzie.videocontentservice.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetShowResponse {
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

    @JsonProperty("averageRating")
    private Double averageRating;

    @JsonProperty("numberOfRatings")
    private int numberOfRatings;

    @JsonProperty("numberOfSeasons")
    private int numberOfSeasons;

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

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }
}
