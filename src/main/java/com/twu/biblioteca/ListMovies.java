package com.twu.biblioteca;

import java.io.IOException;

public class ListMovies implements Command {
    private MovieViewer movieViewer;

    public ListMovies(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
    }

    @Override
    public int getOption() {
        return 5;
    }

    @Override
    public void execute() throws IOException {
        movieViewer.printMovieDetails();
    }

    @Override
    public int getOptionBeforeLogin() {
        return 2;
    }
}
