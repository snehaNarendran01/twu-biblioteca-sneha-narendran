package com.twu.biblioteca;

import java.util.ArrayList;

public class BookViewer {
    private ArrayList<Book> books;

    public BookViewer(ArrayList<Book> books) {
        this.books = books;
    }

    public void printBookDetails() {
        for (Book book :
                books) {
            book.printInformation();
        }
    }
}
