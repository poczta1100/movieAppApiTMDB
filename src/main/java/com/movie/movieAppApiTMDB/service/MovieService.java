package com.movie.movieAppApiTMDB.service;

import com.movie.movieAppApiTMDB.model.MovieDto;
import com.movie.movieAppApiTMDB.webclient.MovieClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {

    private final MovieClient movieClient;

    public MovieDto getMovieWebClientResponse(String input) {

        return movieClient.movieClientApi(input);
    }

}
