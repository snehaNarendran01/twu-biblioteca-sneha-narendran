package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class BookList {
    private ArrayList<String> bookList;
    private ArrayList<String> checkedOutBookList;
    private UserInput userInput;
    private UserOutput userOutput;

    public BookList(UserInput userInput, UserOutput userOutput) {
        this.userInput = userInput;
        this.userOutput = userOutput;
        this.bookList = new ArrayList<>();
        checkedOutBookList = new ArrayList<>();
        bookList.add("Harry Potter");
        bookList.add("Inseparable Twins");
    }

    public void checkout(String title) throws IOException {
        if (!bookList.contains(title)) {
            userOutput.print("Sorry, that book is not available\n");
        } else {
            bookList.remove(title);
            checkedOutBookList.add(title);
            userOutput.print("Thank you! Enjoy the book\n");
        }
    }

    public void returnBook() throws IOException {
        String book = userInput.scanBookTitle();
        if (checkedOutBookList.contains(book)) {
            bookList.add(book);
            userOutput.print("Thank you for returning the book\n");
        } else {
            userOutput.print("That is not a valid book to return.\n");
        }

    }

}
