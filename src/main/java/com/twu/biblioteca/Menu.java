package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private BookViewer bookViewer;
    private BookList bookList;

    public Menu(BookViewer bookViewer, BookList bookInventory) {
        this.bookViewer = bookViewer;
        this.bookList = bookInventory;
    }

    public void showMenu() {
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                bookViewer.printBookDetails();
                break;
            case 2:
                bookList.checkout();
                break;
            case 3:
                String bookToBeReturned = "Harry Potter";
                bookList.returnBook(bookToBeReturned);
                break;
            case 4:
//                    System.exit(0);
            default:
                displayInvalidOptionMessage();
        }

    }


    public void displayMenu() {
        System.out.print("\nSelect any one of the options: \n1: Listing all books\n" +
                "2: Checkout a specified book\n3: Return a book\n4: Quit the application");
    }

    private void displayInvalidOptionMessage() {
        System.out.print("Please select a valid option!");
    }


}
