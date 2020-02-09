package com.twu.biblioteca;

import java.time.Year;
import java.util.ArrayList;

public class BookList {
    private ArrayList<String> bookList;

    public BookList() {
        this.bookList = new ArrayList<>();
        Book book = new Book("Harry Potter", "J.K Rowling", Year.of(1997));
        bookList.add(book.getTitle());
    }

    public void checkout(String title) {
        if (!bookList.contains(title)) {
            System.out.print("Sorry, that book is not available");
        } else {
            bookList.remove(title);
            System.out.print("Thank you! Enjoy the book");
        }
    }

    public void returnBook(String book) {
        if (bookList.contains(book)) {
            System.out.print("Thank you for returning the book");
        } else {
            System.out.print("That is not a valid book to return.");
        }

    }

    public void add(String title) {
        bookList.add(title);
    }
}
