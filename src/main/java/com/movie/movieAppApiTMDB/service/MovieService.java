package com.movie.movieAppApiTMDB.service;

import com.movie.movieAppApiTMDB.model.Movie;
import com.movie.movieAppApiTMDB.model.MovieDto;
import com.movie.movieAppApiTMDB.repository.MovieRepository;
import com.movie.movieAppApiTMDB.webclient.MovieClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {

    private final MovieClient movieClient;
    private final MovieRepository movieRepository;


    public MovieDto getMovieWebClientResponse(String input) {

        return movieClient.movieClientApi(input);
    }


    public List<Movie> getAllFromDatabase() {
        return movieRepository.findAll();
    }
}
