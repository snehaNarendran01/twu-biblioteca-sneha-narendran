package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {

    public static void main(String[] args) throws IOException {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.getWelcomeMessage();
        Console console = new Console();
        UserInput userInput = new UserInput();
        UserOutput userOutput = new UserOutput();
        BookList bookList = new BookList(console);
        BookViewer bookViewer = new BookViewer(console);
        ApplicationQuitter applicationQuitter = new ApplicationQuitter();
        MovieViewer movieViewer = new MovieViewer(console);
        MovieList movieList = new MovieList(userInput, userOutput);
        Validator validator = new Validator(userInput, userOutput);
        User user = User.createUser();
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter,
                movieViewer, movieList, validator, user);
        menu.showMenu();
    }
}
