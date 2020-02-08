package com.twu.biblioteca;

public class Menu {

    private BookViewer bookViewer;

    public Menu(BookViewer bookViewer) {

        this.bookViewer = bookViewer;
    }

    public void showMenu(int option) {
        if(option==1)
        bookViewer.printBookDetails();
    }
}
