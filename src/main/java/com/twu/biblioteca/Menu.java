package com.twu.biblioteca;

public class Menu {
    private UserInput userInput;
    private BookViewer bookViewer;
    private BookList bookList;

    public Menu(BookViewer bookViewer, BookList bookInventory, UserInput userInput) {
        this.bookViewer = bookViewer;
        this.bookList = bookInventory;
        this.userInput = userInput;
    }

    public void showMenu() {
        int option = userInput.scanOption();
        switch (option) {
            case 1:
                bookViewer.printBookDetails();
                break;
            case 2:
                System.out.println("Enter a book to checkout");
                bookList.checkout();
                break;
            case 3:
                System.out.println("Enter a book to return");
                bookList.returnBook();
                break;
            case 4:
                System.exit(0);
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
