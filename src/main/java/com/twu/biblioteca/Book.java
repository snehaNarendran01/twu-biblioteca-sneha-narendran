package com.twu.biblioteca;

import java.io.IOException;
import java.time.Year;


public class Book {
    private String title;
    private String author;
    private Year yearPublished;
    private UserOutput userOutput;

    public Book(String title, String author, Year yearPublished, UserOutput userOutput) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.userOutput = userOutput;
    }

    public void printInformation() throws IOException {
        userOutput.print("Title: " + title + " Author: " + author + " Year Of Publish: " + yearPublished + "\n");
    }
}
