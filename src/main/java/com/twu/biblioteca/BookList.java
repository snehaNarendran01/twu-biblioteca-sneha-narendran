package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class BookList {
    private ArrayList<String> bookList;
    private HashMap<User, String> checkedOutBookList;
    private UserInput userInput;
    private UserOutput userOutput;
    private User user;

    public BookList(UserInput userInput, UserOutput userOutput) {
        this.userInput = userInput;
        this.userOutput = userOutput;
        this.bookList = new ArrayList<>();
        checkedOutBookList = new HashMap<>();
        bookList.add("Harry Potter");
        bookList.add("Inseparable Twins");
    }

    public void checkout() throws IOException {
        userOutput.print("Enter a book title to checkout");
        String title = userInput.scanBookTitle();
        if (!bookList.contains(title)) {
            userOutput.print("Sorry, that book is not available\n");
        } else {
            bookList.remove(title);
            checkedOutBookList.put(user, title);
            userOutput.print("Thank you! Enjoy the book\n");
        }
    }

    public void returnBook() throws IOException {
        String book = userInput.scanBookTitle();
        String bookTakenByUser = checkedOutBookList.get(user);
        if (book.equals(bookTakenByUser)) {
            bookList.add(book);
            userOutput.print("Thank you for returning the book\n");
        } else {
            userOutput.print("That is not a valid book to return.\n");
        }
    }

}
