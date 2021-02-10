package com.movie.movieAppApiTMDB.repository;


import com.movie.movieAppApiTMDB.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
