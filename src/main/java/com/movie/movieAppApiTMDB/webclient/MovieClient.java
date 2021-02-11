package com.movie.movieAppApiTMDB.webclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.movie.movieAppApiTMDB.model.MovieDto;
import com.movie.movieAppApiTMDB.webclient.dto.MovieDataDto;
import com.movie.movieAppApiTMDB.webclient.dto.MovieDataObjectDto;
import com.movie.movieAppApiTMDB.webclient.dto.MovieDataObjectResultsDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class MovieClient {
    private final RestTemplate restTemplate = new RestTemplate();
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

        return MovieDto.builder()
                .amountOfResults(movieDataObjectDto.getTotal_results())
                .movie_title((Arrays.stream(movieDataObjectDto.getResults()).map(MovieDataObjectResultsDto::getTitle).collect(Collectors.toList())))
                .build();

    }
}

