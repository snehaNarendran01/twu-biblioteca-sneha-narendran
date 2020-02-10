package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.getWelcomeMessage();
        BookViewer bookViewer = new BookViewer();
        BookList bookList = new BookList();
        Menu menu = new Menu(bookViewer, bookList);
        menu.displayMenu();
        menu.showMenu();
    }

}
