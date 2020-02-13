package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class MovieList {

    private ArrayList<String> listOfMovies;
    private Console console;

    public MovieList(Console console) {
        this.console = console;
        listOfMovies = new ArrayList<>();
        listOfMovies.add("Life Of Pi");
        listOfMovies.add("Dumbo");
    }

    public void checkout() throws IOException {
        console.print("Enter the name of a movie\n");
        String movieTitle = console.scanMovieTitle();
        if (!listOfMovies.contains(movieTitle)) {
            console.print("Sorry, that movie is not available\n");
        } else {
            console.print("Thank you! Enjoy the movie\n");
            listOfMovies.remove(movieTitle);
        }
    }
}
