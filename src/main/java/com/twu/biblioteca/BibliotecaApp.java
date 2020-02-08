package com.twu.biblioteca;

import java.time.Year;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.getWelcomeMessage();

        Book book = new Book("Famous", "", Year.of(1995));
        book.printTitle();
    }

}
