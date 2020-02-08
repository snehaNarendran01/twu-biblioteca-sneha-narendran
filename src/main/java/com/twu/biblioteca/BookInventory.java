package com.twu.biblioteca;

import java.util.ArrayList;

public class BookInventory {
    private ArrayList<Book> inventory;

    public BookInventory(ArrayList<Book> inventory) {
        this.inventory = inventory;
    }

    public void removeBook(Book book) {
        if (!inventory.contains(book)) {
            System.out.print("Sorry, that book is not available");
            return;
        }
        inventory.remove(book);
        System.out.print("Thank you! Enjoy the book");
    }

    public void addBook(Book book) {
        if (inventory.contains(book)) {
            System.out.print("That is not a valid book to return.");
            return;
        }
        inventory.add(book);
        System.out.print("Thank you for returning the book");

    }
}
