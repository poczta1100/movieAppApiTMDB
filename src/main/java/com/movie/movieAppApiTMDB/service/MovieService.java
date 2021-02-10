package com.movie.movieAppApiTMDB.service;

import com.movie.movieAppApiTMDB.webclient.MovieClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {

    private final MovieClient movieClient;

    public String getMovieWebClientResponse(String input) {

        return movieClient.MovieClientApi(input);
    }

}
