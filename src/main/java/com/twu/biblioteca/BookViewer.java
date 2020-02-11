package com.twu.biblioteca;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;

public class BookViewer {
    private ArrayList<Book> books;
    private UserOutput userOutput;

    public BookViewer(UserOutput userOutput) {
        books = new ArrayList<>();
        books.add(new Book("Famous Five", "Enid Mary Blyton", Year.of(1942), userOutput));
        books.add(new Book("Harry Potter", "J.K. Rowling", Year.of(1997), userOutput));
    }

    public void printBookDetails() throws IOException {
        for (Book book :
                books) {
            book.printInformation();
        }
    }
}
