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

    public String getTitle() {
        return title;
    }

    public void printInformation() {
        System.out.print("Title: " + title + " Author: " + author + " Year Of Publish: " + yearPublished + "\n");
    }
}
