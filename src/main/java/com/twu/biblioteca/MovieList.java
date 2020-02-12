package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class MovieList {

    private ArrayList<String> listOfMovies;
    private UserInput userInput;
    private UserOutput userOutput;

    public MovieList(UserInput userInput, UserOutput userOutput) {
        listOfMovies = new ArrayList<>();
        this.userInput = userInput;
        this.userOutput = userOutput;
        listOfMovies.add("Life Of Pi");
        listOfMovies.add("Dumbo");
    }

    public void checkout(String movieTitle) throws IOException {
        if (!listOfMovies.contains(movieTitle)) {
            userOutput.print("Sorry, that movie is not available\n");
        } else
            userOutput.print("Thank you! Enjoy the movie\n");
    }
}
