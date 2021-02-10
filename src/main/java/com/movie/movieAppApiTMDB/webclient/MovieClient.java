package com.movie.movieAppApiTMDB.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "?api_key=86282f56c1e110a38518bfd885146e9b";
    private final String REQ_URL = "https://api.themoviedb.org/3/search/movie";
    private String query = "";



    public String MovieClientApi(String input) {

        if(input.isEmpty()||input.isBlank()) { query = "&query="+"Jackass";}
        else{ query = "&query="+input;}

        String response = restTemplate.getForObject(
                REQ_URL + apiKey + query
                , String.class);
        return response;
    }



}
