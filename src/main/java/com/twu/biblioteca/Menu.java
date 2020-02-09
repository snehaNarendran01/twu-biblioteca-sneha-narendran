package com.twu.biblioteca;

public class Menu {

    private BookViewer bookViewer;
    private BookInventory bookInventory;

    public Menu(BookViewer bookViewer, BookInventory bookInventory) {
        this.bookViewer = bookViewer;
        this.bookInventory = bookInventory;
    }

    public void showMenu(int option, Book book) {
        if (option == 1)
            bookViewer.printBookDetails();
        if (option == 2)
            bookInventory.remove(book);
        if (option == 3) {
            bookInventory.returnBook(book);
        } else
            displayInvalidOptionMessage();
    }

    private void displayInvalidOptionMessage() {
        System.out.print("Please select a valid option!");
    }

    public void displayMenu() {
        System.out.print("Select any one of the options: \n1: Listing all books\n2: Checkout a specified book\n3: Return a book\n4: Quit the application");
    }
}
