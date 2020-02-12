package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {

    public static void main(String[] args) throws IOException {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.getWelcomeMessage();
        UserInput userInput = new UserInput();
        UserOutput userOutput = new UserOutput();
        User user = new User("", "", "", userOutput);
        BookList bookList = new BookList(userInput, userOutput, user);
        BookViewer bookViewer = new BookViewer(userOutput);
        ApplicationQuitter applicationQuitter = new ApplicationQuitter();
        MovieViewer movieViewer = new MovieViewer(userOutput);
        MovieList movieList = new MovieList(userInput, userOutput);
        Validator validator = new Validator(userInput, userOutput);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator);
        menu.showMenu();
    }
}
