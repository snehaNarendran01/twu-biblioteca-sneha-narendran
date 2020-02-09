package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.getWelcomeMessage();
        BookViewer bookViewer = new BookViewer();
        BookList bookList = new BookList();
        Menu menu = new Menu(bookViewer, bookList);
        menu.displayMenu();
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        menu.showMenu(option);

    }

}
