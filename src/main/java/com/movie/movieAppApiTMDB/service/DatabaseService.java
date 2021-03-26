package com.movie.movieAppApiTMDB.service;

import com.movie.movieAppApiTMDB.model.Movie;
import com.movie.movieAppApiTMDB.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseService {

    private final MovieRepository movieRepository;


    public void AddAndCheckMovieInDatabase(List<String> inputData){

        inputData.stream().forEach(name -> {
            if (!movieRepository.existsMovieByName(name)){
                //System.out.println("Name not found : " + name + " ...adding");
                Movie movie = new Movie();
                movie.setName(name);
                movieRepository.save(movie);
            }
            else{
                System.out.println("Name found : " + name + " ...skipped");
            }
            //System.out.println(name);
        });


    }


}
