package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {

    public static void main(String[] args) throws IOException, InvalidOptionException {
        Console console = new Console();
        WelcomePage welcomePage = new WelcomePage(console);
        welcomePage.getWelcomeMessage();
        BookList bookList = new BookList(console);
        BookViewer bookViewer = new BookViewer(console);
        ApplicationQuitter applicationQuitter = new ApplicationQuitter();
        MovieViewer movieViewer = new MovieViewer(console);
        MovieList movieList = new MovieList(console);
        Validator validator = new Validator(console);
        User user = new User("Jim", "jim12@gmail.com", "9391049708", console);
        Menu menu = new Menu(bookViewer, bookList, console, applicationQuitter,
                movieViewer, movieList, validator, user);
        menu.showBeforeLoginMenu();
    }
}
