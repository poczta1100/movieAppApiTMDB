package com.movie.movieAppApiTMDB.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class MovieDto {
    private int amountOfResults;
    private int inputPages;
    private List<String> movie_title;
    //private int results_found;

    //private ArrayList<Object> content;
    //private Year yearOfProduction;
    //private double avg_vote;
}
