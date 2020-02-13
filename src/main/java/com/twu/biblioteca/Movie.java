package com.twu.biblioteca;

import java.io.IOException;
import java.time.Year;

public class Movie {

    private final String movieTitle;
    private final Year yearReleased;
    private final String directorName;
    private final String rating;
    private Console console;

    public Movie(String movieTitle, Year yearReleased, String directorName, String rating, Console console) {
        this.movieTitle = movieTitle;
        this.yearReleased = yearReleased;
        this.directorName = directorName;
        this.rating = rating;
        this.console = console;
    }

    public void printDetails() throws IOException {
        console.print("Title: " + movieTitle + " Year of Release: " + yearReleased + " Name of Director: " + directorName + " Rating: " + rating + "\n");
    }
}
