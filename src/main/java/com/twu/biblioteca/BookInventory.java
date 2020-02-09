package com.twu.biblioteca;

import java.util.ArrayList;

public class BookInventory {
    private ArrayList<Book> inventory;

    public BookInventory() {
        this.inventory = new ArrayList<>();
        //can add books here
    }

    public void remove(Book book) {
        if (!inventory.contains(book)) {
            System.out.print("Sorry, that book is not available");
            return;
        }
        inventory.remove(book);
        System.out.print("Thank you! Enjoy the book");
    }

    public void add(Book book) {
        inventory.add(book);
    }

    public void returnBook(Book book) {
        if (inventory.contains(book)) {
            add(book);
            System.out.print("Thank you for returning the book");
        } else {
            System.out.print("That is not a valid book to return.");
        }

    }

    public ArrayList<Book> getBooks() {
        return inventory;
    }
}
