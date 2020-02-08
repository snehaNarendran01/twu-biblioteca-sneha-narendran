package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookAlreadyExistException;

public class Menu {

    private BookViewer bookViewer;
    private BookInventory bookInventory;

    public Menu(BookViewer bookViewer, BookInventory bookInventory) {
        this.bookViewer = bookViewer;
        this.bookInventory = bookInventory;
    }

    public void showMenu(int option, Book book) throws BookAlreadyExistException {
        if (option == 1)
            bookViewer.printBookDetails();
        if (option == 2) {
            bookInventory.removeBook(book);
        }
        if (option == 3) {
            bookInventory.addBook(book);
        } else
            displayInvalidOptionMessage();
    }

    private void displayInvalidOptionMessage() {
        System.out.print("Please select a valid option!");
    }
}
