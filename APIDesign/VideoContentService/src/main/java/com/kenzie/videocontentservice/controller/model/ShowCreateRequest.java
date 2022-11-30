package com.kenzie.videocontentservice.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class ShowCreateRequest {
    @NotEmpty
    @JsonProperty("title")
    private String title;

    @JsonProperty("parentalGuideline")
    private String parentalGuideline;

    @Min(0)
    @JsonProperty("episodeLength")
    private int episodeLength;

    @JsonProperty("genre")
    private String genre;

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

