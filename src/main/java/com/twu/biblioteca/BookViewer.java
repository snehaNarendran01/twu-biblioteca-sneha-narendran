package com.twu.biblioteca;

import java.util.ArrayList;

public class BookViewer {
    public void printBookDetails(ArrayList<Book> books) {
        for (Book book :
                books) {
            book.printTitle();

        }
    }
}
