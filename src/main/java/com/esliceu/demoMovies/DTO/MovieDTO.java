package com.esliceu.demoMovies.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public record MovieDTO ( int movieId, String title , String overview , BigDecimal popularity,
                         String releaseDate, double voteAverage)
{}