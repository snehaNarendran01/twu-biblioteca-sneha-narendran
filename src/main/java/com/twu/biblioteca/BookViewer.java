package com.twu.biblioteca;

import java.time.Year;
import java.util.ArrayList;

public class BookViewer {
    private ArrayList<Book> books;

    public BookViewer() {
        books = new ArrayList<>();
        books.add(new Book("Famous Five", "Enid Mary Blyton", Year.of(1942)));
        books.add(new Book("Harry Potter", "J.K Rowling", Year.of(1997)));
    }

    public void printBookDetails() {
        for (Book book :
                books) {
            book.printInformation();
        }
    }
}
