package com.kenzie.videocontentservice.controller;

import com.kenzie.videocontentservice.controller.model.*;
import com.kenzie.videocontentservice.service.ContentService;
import com.kenzie.videocontentservice.service.model.EpisodeInfo;
import com.kenzie.videocontentservice.service.model.ParentalGuideline;
import com.kenzie.videocontentservice.service.model.ShowInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.randomUUID;


@RestController
@RequestMapping("/show")
public class ShowController {

    private ContentService contentService;

    ShowController(ContentService contentService) {
        this.contentService = contentService;
    }

    // Create your endpoints here and add the necessary annotations
   @PostMapping
    public ResponseEntity<ShowResponse> addNewShow(@RequestBody ShowCreateRequest showCreateRequest ){
        ShowInfo show = new ShowInfo();
        show.setShowId(randomUUID().toString());
        show.setTitle(showCreateRequest.getTitle());
        show.setParentalGuideline(ParentalGuideline.valueOf(showCreateRequest.getParentalGuideline()));
        show.setEpisodeLength(showCreateRequest.getEpisodeLength());
        show.setGenre(showCreateRequest.getGenre());
        contentService.createShow(show);

        ShowResponse showResponse = createShowResponse(show);

       return ResponseEntity.created(URI.create("/show/" + showResponse.getId())).body(showResponse);
   }
    @GetMapping("/{showId}")
    public ResponseEntity<GetShowResponse> getShowById(@PathVariable("showId") String showId){
        ShowInfo show = contentService.getShow(showId);
        if (show == null) {
            return ResponseEntity.noContent().build();
        }
        GetShowResponse response = createGetShowResponse(show);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    public ResponseEntity<List<GetShowResponse>> getAllShows(){
        List<ShowInfo> shows = contentService.getAllShows();
        if (shows == null || shows.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<GetShowResponse> response = new ArrayList<>();
        for (ShowInfo show : shows){
            response.add(this.createGetShowResponse(show));
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{showId}/season/{seasonNumber}/episode")
    public ResponseEntity<EpisodeResponse> addNewEpisode(@RequestBody EpisodeCreateRequest episodeCreateRequest ){
        EpisodeInfo episodeInfo = new EpisodeInfo();
        episodeInfo.setShowId(episodeCreateRequest.getShowId());
        episodeInfo.setSeasonNumber(episodeCreateRequest.getSeasonNumber());
        episodeInfo.setEpisodeNumber(episodeCreateRequest.getEpisodeNumber());
        episodeInfo.setTitle(episodeCreateRequest.getTitle());
        episodeInfo.setDescription(episodeCreateRequest.getDescription());
        contentService.addEpisode(episodeInfo);

        EpisodeResponse episodeResponse = createEpisodeResponse(episodeInfo);

        return ResponseEntity.created(URI.create("/show/" + episodeResponse.getShowId() + "/season"
                + episodeResponse.getSeasonNumber() + "/episode" + episodeResponse.getEpisodeNumber())).body(episodeResponse);

    }
    @GetMapping("/{showId}/season/{seasonNumber}/episode/{episodeNumber}")
    public ResponseEntity<GetEpisodeResponse> getEpisodeById(@PathVariable ("showId") String showId,
                                                          @PathVariable ("seasonNumber") String seasonNumber,
                                                          @PathVariable ("episodeNumber") String episodeNumber){
        EpisodeInfo episodeInfo = contentService.getEpisode(showId,seasonNumber,episodeNumber);
        if (episodeInfo == null) {
            return ResponseEntity.noContent().build();
        }

        GetEpisodeResponse episodeResponse = createGetEpisodeResponse(episodeInfo);
        return ResponseEntity.ok(episodeResponse);
    }

    @GetMapping("/{showId}/season/{seasonNumber}/episode/all")
    public ResponseEntity<List<GetEpisodeResponse>> getAllEpisodes(@PathVariable ("showId") String showId,
                                                             @PathVariable ("seasonNumber") String seasonNumber){
        List<EpisodeInfo> episodes = contentService.getAllEpisodesForShow(showId, Integer.valueOf(seasonNumber));

        if (episodes == null || episodes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<GetEpisodeResponse> episodeResponses = new ArrayList<>();
        for (EpisodeInfo episode : episodes){
            episodeResponses.add(this.createGetEpisodeResponse(episode));
        }
        return ResponseEntity.ok(episodeResponses);
    }

    private EpisodeResponse createEpisodeResponse(EpisodeInfo episodeInfo){
        EpisodeResponse episodeResponse = new EpisodeResponse();
        episodeResponse.setShowId(episodeInfo.getShowId());
        episodeResponse.setSeasonNumber(episodeInfo.getSeasonNumber());
        episodeResponse.setEpisodeNumber(episodeInfo.getEpisodeNumber());
        episodeResponse.setTitle(episodeInfo.getTitle());
        episodeResponse.setDescription(episodeInfo.getDescription());
        return episodeResponse;
    }
    private ShowResponse createShowResponse(ShowInfo show) {
        ShowResponse showResponse = new ShowResponse();
        showResponse.setId(show.getShowId());
        showResponse.setTitle(show.getTitle());
        showResponse.setParentalGuideline(show.getParentalGuideline().toString());
        showResponse.setEpisodeLength(show.getEpisodeLength());
        showResponse.setGenre(show.getGenre());
        return showResponse;
    }
    private GetShowResponse createGetShowResponse(ShowInfo show) {
        GetShowResponse showResponse = new GetShowResponse();
        showResponse.setId(show.getShowId());
        showResponse.setTitle(show.getTitle());
        showResponse.setParentalGuideline(show.getParentalGuideline().toString());
        showResponse.setEpisodeLength(show.getEpisodeLength());
        showResponse.setGenre(show.getGenre());
        showResponse.setAverageRating((show.getAverageRating()));
        showResponse.setNumberOfRatings(show.getNumberOfRatings());
        showResponse.setNumberOfSeasons(show.getNumberOfSeasons());
        return showResponse;
    }

    private GetEpisodeResponse createGetEpisodeResponse(EpisodeInfo episodeInfo){
        GetEpisodeResponse episodeResponse = new GetEpisodeResponse();
        episodeResponse.setShowId(episodeInfo.getShowId());
        episodeResponse.setSeasonNumber(episodeInfo.getSeasonNumber());
        episodeResponse.setEpisodeNumber(episodeInfo.getEpisodeNumber());
        episodeResponse.setTitle(episodeInfo.getTitle());
        episodeResponse.setAverageRating(episodeInfo.getAverageRating());
        episodeResponse.setNumberOfRatings(episodeInfo.getNumberOfRatings());
        episodeResponse.setAired(episodeInfo.getAired());
        episodeResponse.setDescription(episodeInfo.getDescription());

        return episodeResponse;
    }

}
