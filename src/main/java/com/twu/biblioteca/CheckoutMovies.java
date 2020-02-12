package com.twu.biblioteca;

import java.io.IOException;

public class CheckoutMovies implements Command {
    private MovieList movieList;
    private UserInput userInput;
    private UserOutput userOutput;

    public CheckoutMovies(MovieList movieList, UserInput userInput, UserOutput userOutput) {
        this.movieList = movieList;
        this.userInput = userInput;
        this.userOutput = userOutput;
    }

    @Override
    public int getOption() {
        return 6;
    }

    @Override
    public void execute() throws IOException {
        userOutput.print("Enter the name of a movie\n");
        String bookTitle = userInput.scanBookTitle();
        movieList.checkout(bookTitle);
    }
}
