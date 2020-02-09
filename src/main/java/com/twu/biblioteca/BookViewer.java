package com.twu.biblioteca;

import java.util.ArrayList;

public class BookViewer {
    private ArrayList<Book> books;

    public BookViewer(BookInventory bookInventory) {
        books = bookInventory.getBooks();
    }

    public void printBookDetails() {
        for (Book book :
                books) {
            book.printInformation();
        }
    }
}
