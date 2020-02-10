package com.twu.biblioteca;

import java.io.IOException;
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

    public void checkout(String title) {
        if (!bookList.contains(title)) {
            System.out.print("Sorry, that book is not available");
        } else {
            bookList.remove(title);
            checkedOutBookList.add(title);
            System.out.print("Thank you! Enjoy the book");
        }
    }

    public void returnBook() throws IOException {
        String book = userInput.scanBookTitle();
        if (checkedOutBookList.contains(book)) {
            bookList.add(book);
            System.out.print("Thank you for returning the book");
        } else {
            System.out.print("That is not a valid book to return.");
        }

    }

}
