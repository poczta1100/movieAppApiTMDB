package com.movie.movieAppApiTMDB.webclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.google.gson.*;
import com.movie.movieAppApiTMDB.model.Movie;
import com.movie.movieAppApiTMDB.model.MovieDto;
import com.movie.movieAppApiTMDB.repository.MovieRepository;
import com.movie.movieAppApiTMDB.service.DatabaseService;
import com.movie.movieAppApiTMDB.service.MovieService;
import com.movie.movieAppApiTMDB.webclient.dto.MovieDataDto;
import com.movie.movieAppApiTMDB.webclient.dto.MovieDataObjectDto;
import com.movie.movieAppApiTMDB.webclient.dto.MovieDataObjectResultsDto;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class MovieClient {

    private final DatabaseService databaseService;

    public MovieClient(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    private final String apiKey = "?api_key=86282f56c1e110a38518bfd885146e9b";
    private final String REQ_URL = "https://api.themoviedb.org/3/search/movie";



    @SneakyThrows
    public MovieDto movieClientApi(String input) {
        String query;
        if(input.isEmpty()||input.isBlank()) { query = "&query="+"Jackass";}
        else{ query = "&query="+input;}

        String url = REQ_URL + apiKey + query;
        URL www = new URL(url);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MovieDataObjectDto movieDataObjectDto = mapper.readValue(www, MovieDataObjectDto.class);
        if (movieDataObjectDto.getTotal_pages() > 1) {
            for (int i = 2; i <= movieDataObjectDto.getTotal_pages(); i++) {
                 url = REQ_URL + apiKey + query + "&page="+i;
                 www = new URL(url);
                 movieDataObjectDto.getResults().addAll(mapper.readValue(www, MovieDataObjectDto.class).getResults());
            }
        }


        List<String> movieList = movieDataObjectDto.getResults().stream().map(MovieDataObjectResultsDto::getTitle).collect(Collectors.toList());

        databaseService.AddAndCheckMovieInDatabase(movieList);

        return MovieDto.builder()
                .movieTitle(movieList)
                .build();

    }

}


