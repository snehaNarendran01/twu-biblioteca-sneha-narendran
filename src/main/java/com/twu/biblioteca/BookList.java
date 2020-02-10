package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BookList {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> bookList;

    public BookList() {
        this.bookList = new ArrayList<>();
        bookList.add("Harry Potter");
    }

    public void checkout() {
        String title = scanner.nextLine();
        if (!bookList.contains(title)) {
            System.out.print("Sorry, that book is not available");
        } else {
            bookList.remove(title);
            System.out.print("Thank you! Enjoy the book");
        }
    }

    public void returnBook() {
        String book = scanner.nextLine();
        if (bookList.contains(book)) {
            System.out.print("Thank you for returning the book");
        } else {
            System.out.print("That is not a valid book to return.");
        }

    }

}
