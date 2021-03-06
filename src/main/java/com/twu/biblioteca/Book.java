package com.twu.biblioteca;

import java.io.IOException;
import java.time.Year;


public class Book {
    private String title;
    private String author;
    private Year yearPublished;
    private Console console;

    public Book(String title, String author, Year yearPublished, Console console) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.console = console;
    }

    public void printInformation() throws IOException {
        console.print("Title: " + title + " Author: " + author + " Year Of Publish: " + yearPublished + "\n");
    }
}
