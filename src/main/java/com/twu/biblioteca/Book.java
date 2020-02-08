package com.twu.biblioteca;

import java.time.Year;

public class Book {
    private String title;
    private String author;
    private Year yearPublished;

    public Book(String title, String author, Year yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public void printTitle() {
        System.out.print("Title: " + title);
    }

    public void printAuthorName() {
        System.out.print("Author: " + author);
    }

    public void printYearOfPublish() {
        System.out.print("Year Of Publish: " + yearPublished);
    }
}
