package com.twu.biblioteca;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;

public class MovieViewer {
    private ArrayList<Movie> movieList;
    private Console console;

    public MovieViewer(Console console) {
        this.console = console;
        movieList = new ArrayList<>();
        movieList.add(new Movie("Life Of Pi", Year.of(2012), "Ang Lee", "9.5", console));
        movieList.add(new Movie("Dumbo", Year.of(2019), "Tim Burton", "7", console));
    }

    public void printMovieDetails() throws IOException {
        for (Movie movie :
                movieList)
            movie.printDetails();
    }
}
