package com.movie.movieAppApiTMDB.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Year;

@Entity
@Getter
@Setter
@Table(name = "Movies")
@NoArgsConstructor
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

}
