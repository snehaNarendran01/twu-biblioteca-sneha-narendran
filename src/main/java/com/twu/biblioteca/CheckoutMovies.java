package com.twu.biblioteca;

import java.io.IOException;

public class CheckoutMovies implements Command {
    private MovieList movieList;

    public CheckoutMovies(MovieList movieList) {
        this.movieList = movieList;
    }

    @Override
    public int getOption() {
        return 6;
    }

    @Override
    public void execute() throws IOException {
        movieList.checkout();
    }

    @Override
    public int getOptionBeforeLogin() {
        return 0;
    }
}
