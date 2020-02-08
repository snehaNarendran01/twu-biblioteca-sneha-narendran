package com.twu.biblioteca;

import java.time.Year;

public class Book {
    String title;
    private String author;
    private Year yearPublished;

    public Book(String title, String author, Year yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public void printTitle() {
        System.out.println(title);
    }
}
