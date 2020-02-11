package com.twu.biblioteca;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;

public class MovieViewer {
    private ArrayList<Movie> movieList;
    private UserOutput userOutput;

    public MovieViewer(UserOutput userOutput) {
        this.userOutput = userOutput;
        movieList = new ArrayList<>();
        movieList.add(new Movie("Life Of Pi", Year.of(2012), "Ang Lee", "9.5", userOutput));
        movieList.add(new Movie("Dumbo", Year.of(2019), "Tim Burton", "7", userOutput));
    }

    public void printMovieDetails() throws IOException {
        for (Movie movie :
                movieList)
            movie.printDetails();
    }
}
