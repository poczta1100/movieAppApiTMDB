package com.movie.movieAppApiTMDB.controller;


import com.movie.movieAppApiTMDB.model.MovieDto;
import com.movie.movieAppApiTMDB.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    //@Autowired
    private final MovieService movieService;

    @GetMapping("/test")
    public MovieDto searchTest(){
        return movieService.getMovieWebClientResponse("");
    }

    @GetMapping("/test/{movie_input_text}")
    public MovieDto searchMovie(@PathVariable String movie_input_text){
        return movieService.getMovieWebClientResponse(movie_input_text);
    }






}
