package com.movie.movieAppApiTMDB.webclient.dto;


import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class MovieDataObjectDto {

    private MovieDataObjectResultsDto results[];
    private int page;
    private int total_pages;
    private int total_results;


    //private String original_title;
    //private Year release_date;
    //private double vote_average;


}
