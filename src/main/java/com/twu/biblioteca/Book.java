package com.twu.biblioteca;

import java.time.Year;

public class Book {
    String title;

    public Book(String title, String author, Year yearPublished) {
        this.title = title;
    }

    public void printTitle() {
        System.out.print(title);
    }
}
