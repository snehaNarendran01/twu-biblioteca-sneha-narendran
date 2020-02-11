package com.twu.biblioteca;

import java.time.Year;

public class Movie {

    private final String movieTitle;
    private final Year yearReleased;
    private final String directorName;
    private final String rating;
    private UserOutput userOutput;

    public Movie(String movieTitle, Year yearReleased, String directorName, String rating, UserOutput userOutput) {
        this.movieTitle = movieTitle;
        this.yearReleased = yearReleased;
        this.directorName = directorName;
        this.rating = rating;
        this.userOutput = userOutput;
    }

    public void printDetails() {
        userOutput.print("Title: " + movieTitle + " Year of Release: " + yearReleased + " Name of Director: " + directorName + " Rating: " + rating + "\n");
    }
}
