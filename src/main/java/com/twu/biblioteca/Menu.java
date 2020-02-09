package com.twu.biblioteca;

public class Menu {
    private BookViewer bookViewer;
    private BookList bookList;

    public Menu(BookViewer bookViewer, BookList bookInventory) {
        this.bookViewer = bookViewer;
        this.bookList = bookInventory;
    }

    public void showMenu(int option) {
        switch (option) {
            case 1:
                bookViewer.printBookDetails();
                break;
            case 2:
                String bookToBeCheckout = "";
                bookList.checkout(bookToBeCheckout);
                break;
            case 3:
                String bookToBeReturned = "";
                bookList.returnBook(bookToBeReturned);
                break;
            case 4:
                return;
            default:
                displayInvalidOptionMessage();
        }
    }

    private void displayInvalidOptionMessage() {
        System.out.print("Please select a valid option!");
    }

    public void displayMenu() {
        System.out.print("\nSelect any one of the options: \n1: Listing all books\n2: Checkout a specified book\n3: Return a book\n4: Quit the application");

    }
}
