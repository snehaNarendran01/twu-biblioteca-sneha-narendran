package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookList {
    private ArrayList<String> bookList;
    private HashMap<User, String> checkedOutBookList;
    private User user;
    private Console console;

    public BookList(Console console) {
        this.console = console;
        this.bookList = new ArrayList<>();
        checkedOutBookList = new HashMap<>();
        bookList.add("Harry Potter");
        bookList.add("Inseparable Twins");
    }

    public void checkout(User user) throws IOException {
        console.print("Enter a book title to checkout");
        String title = console.scanBookTitle();
        if (!bookList.contains(title)) {
            console.print("Sorry, that book is not available\n");
        } else {
            bookList.remove(title);
            checkedOutBookList.put(user, title);
            console.print("Thank you! Enjoy the book\n");
        }
    }

    public void returnBook(User user) throws IOException {
        String book = console.scanBookTitle();
        String bookTakenByUser = checkedOutBookList.get(user);
        if (book.equals(bookTakenByUser)) {
            bookList.add(book);
            console.print("Thank you for returning the book\n");
        } else {
            console.print("That is not a valid book to return.\n");
        }
    }

    public User issuedBy() throws IOException {
        User issueByUser = null;
        String book = console.scanBookTitle();
        for (Map.Entry<User, String> entry : checkedOutBookList.entrySet()) {
            if (entry.getValue().equals(book)) {
                issueByUser = entry.getKey();
            }
        }
        return issueByUser;
    }
}
