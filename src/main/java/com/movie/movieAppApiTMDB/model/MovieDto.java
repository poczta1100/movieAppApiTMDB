package com.movie.movieAppApiTMDB.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Year;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private String name;
    private Year yearOfProduction;
    private double avg_vote;
}
