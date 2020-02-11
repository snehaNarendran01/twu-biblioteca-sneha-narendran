package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {

    public static void main(String[] args) throws IOException {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.getWelcomeMessage();
        UserInput userInput = new UserInput();
        UserOutput userOutput = new UserOutput();
        BookList bookList = new BookList(userInput);
        BookViewer bookViewer = new BookViewer(userOutput);
        ApplicationQuitter applicationQuitter = new ApplicationQuitter();
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter);
        menu.displayMenu();
        menu.showMenu();
    }
}
