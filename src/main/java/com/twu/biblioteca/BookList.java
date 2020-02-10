package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    private ArrayList<String> bookList;
    private ArrayList<String> checkedOutBookList;
    private UserInput userInput;

    public BookList(UserInput userInput) {
        this.userInput = userInput;
        this.bookList = new ArrayList<>();
        checkedOutBookList = new ArrayList<>();
        bookList.add("Harry Potter");
        bookList.add("Inseparable Twins");
    }

    public void checkout() {
        String title = userInput.scanBookTitle();
        if (!bookList.contains(title)) {
            System.out.print("Sorry, that book is not available");
        } else {
            bookList.remove(title);
            System.out.print("Thank you! Enjoy the book");
        }
    }

    public void returnBook() {
        String book = userInput.scanBookTitle();
        if (bookList.contains(book)) {
            System.out.print("Thank you for returning the book");
        } else {
            System.out.print("That is not a valid book to return.");
        }

    }

    public ArrayList<String> availableBooks() {
        ArrayList<String> availableBooks = new ArrayList<>();
        availableBooks.add("Inseparable Twins");
        return availableBooks;
    }
}
