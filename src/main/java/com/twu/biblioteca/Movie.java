package com.twu.biblioteca;

import java.time.Year;

public class Movie {

    private final String movieTitle;
    private final Year yearReleased;
    private final String directorname;
    private final String rating;
    private UserOutput userOutput;

    public Movie(String movieTitle, Year yearReleased, String directorName, String rating, UserOutput userOutput) {
        this.movieTitle = movieTitle;
        this.yearReleased = yearReleased;
        this.directorname = directorName;
        this.rating = rating;
        this.userOutput = userOutput;
    }

    public void printDetails() {
        userOutput.print("Title: Life Of Pi Year of Release: 2012 Name of Director: Ang Lee Rating: 9.5\n");
    }
}
