package com.movie.movieAppApiTMDB.repository;


import com.movie.movieAppApiTMDB.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    //boolean existsByName(String name);
    boolean existsMovieByName(String name);

}
